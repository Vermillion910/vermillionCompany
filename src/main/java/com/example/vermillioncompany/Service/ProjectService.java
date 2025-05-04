package com.example.vermillioncompany.Service;

import com.example.vermillioncompany.Model.Project;
import com.example.vermillioncompany.Repository.ProjectRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepo projectRepo;

    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

    public Optional<Project> getProjectById(Long id) {
        return projectRepo.findById(id);
    }

    public Project createProject(Project project) {
        return projectRepo.save(project);
    }

    public Project updateProject(Long id, Project updatedProject) {
        return projectRepo.findById(id)
                .map(existing -> {
                    existing.setProjectName(updatedProject.getProjectName());
                    existing.setStartDate(updatedProject.getStartDate());
                    existing.setEndDate(updatedProject.getEndDate());
                    existing.setBudget(updatedProject.getBudget());
                    existing.setClient(updatedProject.getClient());
                    existing.setProjectManager(updatedProject.getProjectManager());
                    return projectRepo.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Project not found"));
    }

    public void deleteProject(Long id) {
        projectRepo.deleteById(id);
    }
}
