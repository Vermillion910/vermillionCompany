package com.example.vermillioncompany.Controller;

import com.example.vermillioncompany.Model.Developer;
import com.example.vermillioncompany.Service.DeveloperService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/developers")
public class DeveloperController {

    private final DeveloperService developerService;
    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("developers", developerService.getAllDevelopers());
        return "developers/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("developer", new Developer());
        return "developers/form";
    }

    @PostMapping
    public String create(@ModelAttribute Developer developer) {
        developerService.createDeveloper(developer);
        return "redirect:/developers";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("developer",
                developerService.getDeveloperById(id).orElseThrow(() -> new RuntimeException("Not found")));
        return "developers/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Developer developer) {
        developerService.updateDeveloper(id, developer);
        return "redirect:/developers";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        developerService.deleteDeveloper(id);
        return "redirect:/developers";
    }
}
