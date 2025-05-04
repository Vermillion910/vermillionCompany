package com.example.vermillioncompany.Controller;

import com.example.vermillioncompany.Model.Client;
import com.example.vermillioncompany.Service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "clients/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("client", new Client());
        return "clients/form";
    }

    @PostMapping
    public String create(@ModelAttribute Client client) {
        clientService.createClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("client",
                clientService.getClientById(id).orElseThrow(() -> new RuntimeException("Not found")));
        return "clients/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Client client) {
        clientService.updateClient(id, client);
        return "redirect:/clients";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        clientService.deleteClient(id);
        return "redirect:/clients";
    }
}
