package com.nothing.demo.dao;

import com.nothing.demo.domain.Book;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

    @Query(value = "SELECT b FROM Book b WHERE b.user.username = :username")
    List<Book> findAllForUser(@Param("username") String username);
}
