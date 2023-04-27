package com.example.dz26.service;

import java.util.List;

import com.example.dz26.domain.AutoBlog;
import com.example.dz26.domain.Client;
import com.example.dz26.repos.AutoBlogRepo;
import com.example.dz26.repos.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoBlogService {

    @Autowired
    private AutoBlogRepo repo;

    public List<AutoBlog> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    public void save(AutoBlog autoBlog) {
        repo.save(autoBlog);
    }

    public AutoBlog get(Long id){

        return repo.findById(id).get();
    }

    public void delete(Long id){

        repo.deleteById(id);
    }

}
