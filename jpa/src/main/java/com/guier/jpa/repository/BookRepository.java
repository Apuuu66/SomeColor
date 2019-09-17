package com.guier.jpa.repository;

import com.guier.jpa.pojo.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByName(String name);
}
