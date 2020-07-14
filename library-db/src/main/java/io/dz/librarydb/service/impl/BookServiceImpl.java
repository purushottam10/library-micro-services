package io.dz.librarydb.service.impl;

import io.dz.librarydb.dao.BookDaoDsl;
import io.dz.librarydb.dto.ResponseDto;
import io.dz.librarydb.util.DateUtil;
import io.dz.librarydb.config.PropertiesConfig;
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
import org.springframework.cache.annotation.CachePut;
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
//    private BookDao bookDao;
    private RestTemplate restTemplate;
    private PropertiesConfig propertiesConfig;
    private BookDaoDsl bookDaoDsl;
    @Autowired
    public BookServiceImpl( RestTemplate restTemplate,BookDaoDsl bookDaoDsl,PropertiesConfig propertiesConfig) {
        this.restTemplate = restTemplate;
        this.propertiesConfig = propertiesConfig;
        this.bookDaoDsl = bookDaoDsl;
    }

    @Cacheable(value = "book",key = "'book'")

    @Override
    public ResponseDto<Book> getAll() {
        ResponseDto<Book> bookResponseDto = new ResponseDto<>();
        bookResponseDto.setData((List<Book>)bookDaoDsl.getAll());
        bookDaoDsl.getAll();
        return bookResponseDto;
    }

    @Override
    public Book save(Book book) {
        LOGGER.info("save book");
        book.setBookId("pu".concat(RandomStringUtils.randomAlphabetic(8)).toUpperCase());
        book.setAvailable(true);
        book.setCreatedAt(new Date(System.currentTimeMillis()));
        return bookDaoDsl.save(book);
    }

    @Override
    @CachePut(value = "book",key = "#id")
    public Book getById(String id) {
        LOGGER.info("retrieve book by Id ");
        return bookDaoDsl.getById(id);
    }

    @Override
    public Book update(Book book) {
        this.getById(book.getBookId());
        book.setUpdatedAt(new Date(System.currentTimeMillis()));
        return bookDaoDsl.update(book);
    }

    @Override
    public void delete(Book book) {
         bookDaoDsl.delete(book);
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
        if (!bookDaoDsl.findAllAvailableBook().stream().map(Book::getBookId).collect(Collectors.toList()).containsAll(bookIds)) {
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
                bookDaoDsl.save(book);
            });
            return bookIds;
         }
    }

    @Override
    public Book returnBook(String bookId, String memberId) {
        Book book = bookDaoDsl.findIssuedBook(bookId, memberId);
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
            return bookDaoDsl.save(book);
        }
        throw new RestException("Book not found in Library List", HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public List<Book> getAllBook() {
        return bookDaoDsl.getAll();
    }
}
