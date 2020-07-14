package io.dz.librarydb.dao;

import io.dz.librarydb.model.Book;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookDaoDsl extends BaseDao<Book>{
    List<Book> findAllAvailableBook();
    Book findIssuedBook(@Param("bookId")String bookId, @Param("memberId") String memberId);
}
