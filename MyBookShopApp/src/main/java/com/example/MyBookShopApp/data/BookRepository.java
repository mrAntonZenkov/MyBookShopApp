package com.example.MyBookShopApp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findBookByAuthor_FirstName(String name);
}
