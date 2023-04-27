package com.example.dz26.repos;

import java.util.List;

import com.example.dz26.domain.AutoBlog;
import com.example.dz26.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AutoBlogRepo extends JpaRepository<AutoBlog, Long> {
    @Query("SELECT p From AutoBlog p WHERE CONCAT(p.date, '', p.author, '', p.text) LIKE %?1%")
    List<AutoBlog> search(String keyword);

}
