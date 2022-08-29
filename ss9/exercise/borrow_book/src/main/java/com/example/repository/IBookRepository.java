package com.example.repository;

import com.example.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IBookRepository extends JpaRepository<Book,Long> {
    Page<Book> findAllByNameContaining(String name, Pageable pageable);

    @Modifying
    @Query(value = "update book set book.amount = book.amount - 1 where book.id = :id", nativeQuery = true)
    void borrowBook(@Param("id") Long id);

    @Modifying
    @Query(value = "update book set book.amount = book.amount + 1 where book.id = :id", nativeQuery = true)
    void giveBookBack(@Param("id") Long id);
}
