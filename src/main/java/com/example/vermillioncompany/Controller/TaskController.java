package com.example.vermillioncompany.Controller;

import com.example.vermillioncompany.Model.Task;
import com.example.vermillioncompany.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAll() { return taskService.getAllTasks(); }
    @GetMapping("/{id}") public Optional<Task> get(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping
    public Task create(@RequestBody Task t) {
        return taskService.createTask(t);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task t) {
        return taskService.updateTask(id, t);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}

