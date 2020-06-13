package io.dz.librarydb.dao;

import io.dz.librarydb.model.Book;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;

@Repository
@Transactional
public interface BookDao extends CrudRepository<Book, String> ,JpaSpecificationExecutor<Book> {
    @Query(value = "FROM Book b WHERE b.available = true")
    Collection<Book> findAllAvailableBook();

   @Query(value = "from Book b where b.available = false and b.bookId = :bookId and b.memberId= :memberId")
    Book findIssuedBook(@Param("bookId")String bookId,@Param("memberId") String memberId);
}
