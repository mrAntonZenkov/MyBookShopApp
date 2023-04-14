package com.example.MyBookShopApp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findBookByAuthor_FirstName(String name);

    @Query("from Book")
    List<Book> customFindAllBooks();

    //NEW BOOK REST REPOSITORY COMMAND

    List<Book> findBookByAuthorFirstNameContaining(String authorFirstName);

    List<Book> findBookByTitleContaining(String bookTitle);

    List<Book> findBookByPriceOldBetween(Integer min, Integer max);

    List<Book> findBookByPriceOldIs(Integer max);

    @Query("from Book where isBestseller=1")
    List<Book> getBestsellers();

    @Query(value = "select * from books where discount = (select max(discount) from books)", nativeQuery = true)
    List<Book> getBooksWithMaxDiscount();
}
