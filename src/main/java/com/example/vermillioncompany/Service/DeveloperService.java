package com.example.vermillioncompany.Service;

import com.example.vermillioncompany.Model.Developer;
import com.example.vermillioncompany.Repository.DeveloperRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeveloperService {

    private final DeveloperRepo developerRepo;

    @Autowired
    public DeveloperService(DeveloperRepo developerRepo) {
        this.developerRepo = developerRepo;
    }

    public List<Developer> getAllDevelopers() {
        return developerRepo.findAll();
    }

    public Optional<Developer> getDeveloperById(Long id) {
        return developerRepo.findById(id);
    }

    public Developer createDeveloper(Developer developer) {
        return developerRepo.save(developer);
    }

    public Developer updateDeveloper(Long id, Developer updatedDeveloper) {
        return developerRepo.findById(id).map(dev -> {
            dev.setFirstName(updatedDeveloper.getFirstName());
            dev.setLastName(updatedDeveloper.getLastName());
            dev.setEmail(updatedDeveloper.getEmail());
            dev.setPhoneNumber(updatedDeveloper.getPhoneNumber());
            dev.setSpecialization(updatedDeveloper.getSpecialization());
            return developerRepo.save(dev);
        }).orElseThrow(() -> new RuntimeException("Разработчик не найден с id: " + id));
    }

    public void deleteDeveloper(Long id) {
        developerRepo.deleteById(id);
    }
}
