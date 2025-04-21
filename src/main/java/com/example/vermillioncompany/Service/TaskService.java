package com.example.vermillioncompany.Service;

import com.example.vermillioncompany.Model.Task;
import com.example.vermillioncompany.Repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepo taskRepo;

    @Autowired
    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepo.findById(id);
    }

    public Task createTask(Task task) {
        return taskRepo.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        return taskRepo.findById(id).map(task -> {
            task.setTaskName(updatedTask.getTaskName());
            task.setAssignedTo(updatedTask.getAssignedTo());
            task.setStatus(updatedTask.getStatus());
            task.setDueDate(updatedTask.getDueDate());
            task.setDescription(updatedTask.getDescription());
            task.setProject(updatedTask.getProject());
            return taskRepo.save(task);
        }).orElseThrow(() -> new RuntimeException("Задача не найдена с id: " + id));
    }

    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }
}
