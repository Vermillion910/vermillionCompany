package com.example.vermillioncompany.Mapper;

import com.example.vermillioncompany.DTO.ProjectDTO;
import com.example.vermillioncompany.Model.Client;
import com.example.vermillioncompany.Model.Developer;
import com.example.vermillioncompany.Model.Project;

import java.time.LocalDate;

public class ProjectMapper {

    public static ProjectDTO toDTO(Project project) {
        ProjectDTO dto = new ProjectDTO();
        dto.setProjectId(project.getProjectId());
        dto.setProjectName(project.getProjectName());
        dto.setClientId(project.getClient().getClientId());
        dto.setProjectManagerId(project.getProjectManager().getDeveloperId());
        dto.setStartDate(project.getStartDate().toString());
        dto.setEndDate(project.getEndDate() != null ? project.getEndDate().toString() : null);
        dto.setBudget(project.getBudget());
        return dto;
    }

    public static Project toEntity(ProjectDTO dto, Client client, Developer manager) {
        Project project = new Project();
        project.setProjectName(dto.getProjectName());
        project.setClient(client);
        project.setProjectManager(manager);
        project.setStartDate(LocalDate.parse(dto.getStartDate()));
        if (dto.getEndDate() != null) {
            project.setEndDate(LocalDate.parse(dto.getEndDate()));
        }
        project.setBudget(dto.getBudget());
        return project;
    }
}
