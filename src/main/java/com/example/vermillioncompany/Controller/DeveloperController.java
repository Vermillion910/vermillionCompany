package com.example.vermillioncompany.Controller;
import com.example.vermillioncompany.Model.Developer;
import com.example.vermillioncompany.Service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("/api/developers")
public class DeveloperController {

    private DeveloperService s;

    @Autowired
    public DeveloperController(DeveloperService s) {
        this.s = s;
    }

    @GetMapping
    public List<Developer> all() {
        return s.getAllDevelopers();
    }

    @GetMapping("/{id}")
    public Optional<Developer> get(@PathVariable Long id) {
        return s.getDeveloperById(id);
    }

    @PostMapping
    public Developer create(@RequestBody Developer d) {
        return s.createDeveloper(d);
    }

    @PutMapping("/{id}")
    public Developer update(@PathVariable Long id, @RequestBody Developer d) {
        return s.updateDeveloper(id, d);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        s.deleteDeveloper(id);
    }
}