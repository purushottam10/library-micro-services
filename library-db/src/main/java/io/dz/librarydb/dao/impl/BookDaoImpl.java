package io.dz.librarydb.dao.impl;

import com.querydsl.core.QueryFactory;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.dz.librarydb.dao.BookDao;
import io.dz.librarydb.dao.BookDaoDsl;
import io.dz.librarydb.model.Book;
import io.dz.librarydb.model.QBook;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class BookDaoImpl implements BookDaoDsl {

    @PersistenceContext
    private EntityManager em;

   @Override

    public Book save(Book book) {
       em.persist(book);
        return book;
    }

    @Transactional(readOnly = true)
    @Override
    public Book getById(String bookId) {
        JPAQuery<Book> bookJPAQuery = new JPAQuery<>(em);
        QBook qBook = QBook.book;
        return (Book) bookJPAQuery.from(qBook).where(qBook.bookId.eq(bookId)).fetch();
    }


    @Override
    @Transactional(readOnly = true)
    public List<Book> getAll() {
       JPAQuery<Book> bookJPAQuery = new  JPAQuery<>(em);
       QBook qBook= QBook.book;
       return  bookJPAQuery.select(qBook).from(qBook).where(qBook.title.contains("spring")).fetch();
    }

    @Override
    public List<Book> findAllAvailableBook() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QBook qBook = QBook.book;
        return ((List<Book>) queryFactory.from(qBook).where(qBook.available.eq(true)));
    }
}
