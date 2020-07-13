package io.dz.librarydb.dao;

import io.dz.librarydb.model.Book;

import java.util.List;

public interface BookDaoDsl{
    Book save(Book book);
    Book getById(String bookId);
    List<Book> getAll();
    List<Book> findAllAvailableBook();
}
