package com.example.vermillioncompany.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProjectDTO {
    private Long projectId;
    private String projectName;
    private Long clientId;
    private Long projectManagerId;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal budget;

    public ProjectDTO() {
    }

    public ProjectDTO(Long projectId, String projectName, Long clientId, Long projectManagerId,
                      LocalDate startDate, LocalDate endDate, BigDecimal budget) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.clientId = clientId;
        this.projectManagerId = projectManagerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    // Геттеры и сеттеры…

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getProjectManagerId() {
        return projectManagerId;
    }

    public void setProjectManagerId(Long projectManagerId) {
        this.projectManagerId = projectManagerId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}
