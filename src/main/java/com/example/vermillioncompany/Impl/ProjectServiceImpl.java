package com.example.vermillioncompany.Impl;

import com.example.vermillioncompany.DTO.ProjectDTO;
import com.example.vermillioncompany.Model.Project;
import com.example.vermillioncompany.Model.Client;
import com.example.vermillioncompany.Model.Developer;
import com.example.vermillioncompany.Repository.ProjectRepo;
import com.example.vermillioncompany.Repository.ClientRepo;
import com.example.vermillioncompany.Repository.DeveloperRepo;
import com.example.vermillioncompany.Mapper.ProjectMapper;
import com.example.vermillioncompany.Service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl extends ProjectService {

    private final ProjectRepo projectRepo;
    private final ClientRepo clientRepo;
    private final DeveloperRepo developerRepo;

    public ProjectServiceImpl(ProjectRepo projectRepo, ClientRepo clientRepo, DeveloperRepo developerRepo) {
        super(projectRepo,projectRepo,ClientRepo clientRepo,  developerRepo);
        this.projectRepo = projectRepo;
        this.clientRepo = clientRepo;
        this.developerRepo = developerRepo;
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        return projectRepo.findAll()
                .stream()
                .map(ProjectMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDTO getProjectById(Long id) {
        return projectRepo.findById(id)
                .map(ProjectMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Project not found"));
    }

    @Override
    public ProjectDTO createProject(ProjectDTO dto) {
        Client client = clientRepo.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Developer manager = developerRepo.findById(dto.getProjectManagerId())
                .orElseThrow(() -> new RuntimeException("Developer not found"));

        Project project = ProjectMapper.toEntity(dto, client, manager);
        Project saved = projectRepo.save(project);
        return ProjectMapper.toDTO(saved);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepo.deleteById(id);
    }
}
