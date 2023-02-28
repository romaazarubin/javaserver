package com.example.libr;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT p From Book p WHERE CONCAT(p.name, '', p.publishing, '', p.date_of_issue, '', p.fio, '', p.date_of_delivery) LIKE %?1%")
    List<Book> search(String keyword);

}
