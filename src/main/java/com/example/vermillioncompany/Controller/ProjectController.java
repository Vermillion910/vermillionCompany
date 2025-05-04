package com.example.vermillioncompany.Controller;

import com.example.vermillioncompany.Model.Project;
import com.example.vermillioncompany.Service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService svc) {
        this.projectService = svc;
    }

    // 1) GET — список проектов
    @GetMapping
    public String listProjects(Model model) {
        model.addAttribute("projects", projectService.getAllProjects());
        return "projects/list";              // thymeleaf-шаблон projects/list.html
    }

    // 2) GET — форма создания
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("project", new Project());
        return "projects/form";              // projects/form.html
    }

    // 3) POST — создание + PRG: редирект на список
    @PostMapping
    public String createProject(@ModelAttribute Project project) {
        projectService.createProject(project);
        return "redirect:/projects";         // PRG: редирект на GET /projects
    }

    // 4) GET — форма редактирования
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("project", projectService.getProjectById(id)
                .orElseThrow(() -> new RuntimeException("Not found")));
        return "projects/form";
    }

    // 5) POST — обновление + PRG
    @PostMapping("/{id}")
    public String updateProject(@PathVariable Long id, @ModelAttribute Project project) {
        projectService.updateProject(id, project);
        return "redirect:/projects";
    }

    // 6) POST — удаление + PRG
    @PostMapping("/{id}/delete")
    public String deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return "redirect:/projects";
    }
}
