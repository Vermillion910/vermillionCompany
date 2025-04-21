package com.example.vermillioncompany.Repository;

import com.example.vermillioncompany.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepo extends JpaRepository<Client,Long> {
}
