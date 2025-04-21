package com.example.vermillioncompany.Repository;

import com.example.vermillioncompany.Model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepo extends JpaRepository<Developer, Long> {
}
