package io.dz.librarydb.dao.impl;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.dz.librarydb.dao.BookDaoDsl;
import io.dz.librarydb.model.Book;
import io.dz.librarydb.model.QBook;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDaoDsl {

    public BookDaoImpl(){
        super();
        setClazz(Book.class);
    }
    protected JPAQueryFactory queryFactory = new JPAQueryFactory(session);
    @Override
    public List<Book> findAllAvailableBook() {
        QBook qBook = QBook.book;
        return (List<Book>) queryFactory.from(qBook).where(qBook.available.eq(true)).fetch();
    }

    @Override
    public Book findIssuedBook(String bookId, String memberId) {
        return null;
    }
}
