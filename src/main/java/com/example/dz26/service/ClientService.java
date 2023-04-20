package com.example.dz26.service;

import java.util.List;

import com.example.dz26.domain.Client;
import com.example.dz26.repos.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repo;

    public List<Client> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    public void save(Client client) {
        repo.save(client);
    }

    public Client get(Long id){
        return repo.findById(id).get();
    }

    public void delete(Long id){
        repo.deleteById(id);
    }

}
