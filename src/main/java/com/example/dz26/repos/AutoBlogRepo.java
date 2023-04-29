package com.example.dz26.repos;

import java.util.List;

import com.example.dz26.domain.AutoBlog;
import com.example.dz26.domain.Client;
import com.example.dz26.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AutoBlogRepo extends JpaRepository<AutoBlog, Long> {
    @Query("SELECT p From AutoBlog p WHERE p.author LIKE %?1%")
    List<AutoBlog> searchAuthor(String keyword);

    @Query("SELECT p From AutoBlog p WHERE p.date LIKE %?1%")
    List<AutoBlog> searchDate(String keyword);

    @Query("SELECT p From AutoBlog p WHERE concat(p.date, '', p.author) LIKE %?1%")
    List<AutoBlog> searchDateAuthor(String keyword);

    @Query("SELECT p From AutoBlog p WHERE p.text LIKE %?1%")
    List<AutoBlog> searchText(String keyword);

    @Query("SELECT p From AutoBlog p WHERE concat(p.date, '', p.text) LIKE %?1%")
    List<AutoBlog> searchDateText(String keyword);

    @Query("SELECT p From AutoBlog p WHERE CONCAT(p.date, '', p.author, '', p.text) LIKE %?1%")
    List<AutoBlog> search(String keyword);

}
