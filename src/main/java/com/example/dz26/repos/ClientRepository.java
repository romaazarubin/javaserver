package com.example.dz26.repos;


import java.util.List;

import com.example.dz26.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT p From Client p WHERE CONCAT(p.name, '', p.content, '', p.departure_city, '', p.departure_date, '', p.arrival_city, '', p.arrival_date) LIKE %?1%")
    List<Client> search(String keyword);

}