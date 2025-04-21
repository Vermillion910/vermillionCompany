package com.example.vermillioncompany.Controller;

import com.example.vermillioncompany.Model.Client;
import com.example.vermillioncompany.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/api/clients")
public class ClientController {

    private ClientService service;

    @Autowired
    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping public List<Client> all() {
        return service.getAllClients();
    }

    @GetMapping("/{id}")
    public Optional<Client> get(@PathVariable Long id) {
        return service.getClientById(id);
    }

    @PostMapping
    public Client create(@RequestBody Client c) {
        return service.createClient(c);
    }

    @PutMapping("/{id}")
    public Client update(@PathVariable Long id, @RequestBody Client c) {
        return service.updateClient(id, c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteClient(id);
    }
}