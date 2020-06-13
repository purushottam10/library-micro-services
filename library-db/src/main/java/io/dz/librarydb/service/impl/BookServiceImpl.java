package io.dz.librarydb.service.impl;

import io.dz.librarydb.dto.ResponseDto;
import io.dz.librarydb.util.DateUtil;
import io.dz.librarydb.config.PropertiesConfig;
import io.dz.librarydb.dao.BookDao;
import io.dz.librarydb.exception.RestException;
import io.dz.librarydb.model.Book;
import io.dz.librarydb.model.Member;
import io.dz.librarydb.model.UserLimit;
import io.dz.librarydb.service.BookService;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);
    private BookDao bookDao;
    private RestTemplate restTemplate;
    private PropertiesConfig propertiesConfig;
    @Autowired
    public BookServiceImpl(BookDao bookDao, RestTemplate restTemplate,PropertiesConfig propertiesConfig) {
        this.bookDao = bookDao;
        this.restTemplate = restTemplate;
        this.propertiesConfig = propertiesConfig;
    }

    @Cacheable(value = "book",key = "'book'")
    @Override
    public ResponseDto<Book> getAll() {
        ResponseDto<Book> bookResponseDto = new ResponseDto<>();
        bookResponseDto.setData((List<Book>)bookDao.findAll());
        return bookResponseDto;
    }

    @Override
    public Book save(Book book) {
        LOGGER.info("save book");
        book.setBookId("pu".concat(RandomStringUtils.randomAlphabetic(8)).toUpperCase());
        book.setAvailable(true);
        book.setCreatedAt(new Date(System.currentTimeMillis()));
        return bookDao.save(book);
    }

    @Override
    @Cacheable(value = "book",key = "'bookCache'")
    public Book getById(String id) {
        LOGGER.info("retrieve book by Id ");
        return bookDao.findById(id).orElseThrow(()->new RestException("no such Book found in the Collection",HttpStatus.NOT_FOUND));
    }

    @Override
    public Book update(Book book) {
        this.getById(book.getBookId());
        book.setUpdatedAt(new Date(System.currentTimeMillis()));
        return bookDao.save(book);
    }

    @Override
    public void delete(Book book) {
         bookDao.delete(book);
    }

    @Override
    public List<String> borrowBook(String memberId, List<String> bookIds) {
        restTemplate.getForObject(propertiesConfig.getMemberServiceUrl() + "getById/" + memberId, Member.class);
        UserLimit userLimit = restTemplate.getForObject(propertiesConfig.getUserLimitUrl() + "getById/" + memberId, UserLimit.class);
       if(Objects.nonNull(userLimit)){
           if (userLimit.getTotal_book() > 5) {
               throw new RestException("you have already Borrowed max no of Book",HttpStatus.NOT_ACCEPTABLE);
           }
        if (userLimit.getTotal_book() + bookIds.size() > 5) {
            throw new RestException("you can't borrow more than 5 book",HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
        }
       }
        if (!bookDao.findAllAvailableBook().stream().map(Book::getBookId).collect(Collectors.toList()).containsAll(bookIds)) {
            throw new RestException("Requested books are Not Available in Library",HttpStatus.NOT_FOUND);
        } else {
            if(Objects.nonNull(userLimit)){
                userLimit.setTotal_book(userLimit.getTotal_book()+bookIds.size());
                restTemplate.put(propertiesConfig.getUserLimitUrl()+"/update",userLimit,ResponseEntity.class);
            }else {
                userLimit = new UserLimit();
                userLimit.setTotal_book(bookIds.size());
                userLimit.setMemberId(memberId);
                restTemplate.put(propertiesConfig.getUserLimitUrl()+"/update",userLimit,ResponseEntity.class);
            }
            bookIds.forEach(bookId -> {
                Book book = getById(bookId);
                book.setAvailable(false);
                book.setDueDate(new Date(System.currentTimeMillis()));
                book.setReturnDate(DateUtil.addDays(new Date(System.currentTimeMillis()), 7));
                book.setMemberId(memberId);
                bookDao.save(book);
            });
            return bookIds;
         }
    }

    @Override
    public Book returnBook(String bookId, String memberId) {
        Book book = bookDao.findIssuedBook(bookId, memberId);
        if (Objects.nonNull(book)) {
            book.setDueDate(null);
            book.setReturnDate(null);
            book.setMemberId(Strings.EMPTY);
            book.setAvailable(true);
            UserLimit userLimit = restTemplate.getForObject(propertiesConfig.getUserLimitUrl() + "getById/" + memberId, UserLimit.class);
            if (Objects.nonNull(userLimit)) {
                userLimit.setTotal_book(userLimit.getTotal_book() - 1);
                userLimit.setMemberId(memberId);
                restTemplate.put(propertiesConfig.getUserLimitUrl() + "/update", userLimit, ResponseEntity.class);
            } else {
                throw new RestException("entery Doesn't match", HttpStatus.NOT_ACCEPTABLE);
            }
            return bookDao.save(book);
        }
        throw new RestException("Book not found in Library List", HttpStatus.NOT_ACCEPTABLE);
    }
}
