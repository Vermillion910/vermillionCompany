package com.example.vermillioncompany.Service;

import com.example.vermillioncompany.Model.Project;
import com.example.vermillioncompany.Repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepo projectRepository;

    @Autowired
    public ProjectService(ProjectRepo projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Long id, Project updatedProject) {
        return projectRepository.findById(id).map(project -> {
            project.setProjectName(updatedProject.getProjectName());
            project.setClient(updatedProject.getClient());
            project.setProjectManager(updatedProject.getProjectManager());
            project.setStartDate(updatedProject.getStartDate());
            project.setEndDate(updatedProject.getEndDate());
            project.setBudget(updatedProject.getBudget());
            return projectRepository.save(project);
        }).orElseThrow(() -> new RuntimeException("Проект не найден с id: " + id));
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
