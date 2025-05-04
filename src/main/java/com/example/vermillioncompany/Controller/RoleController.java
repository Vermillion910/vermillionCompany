package com.example.vermillioncompany.Controller;

import com.example.vermillioncompany.Model.Role;
import com.example.vermillioncompany.Service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("roles", roleService.getAllRoles());
        return "roles/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("role", new Role());
        return "roles/form";
    }

    @PostMapping
    public String create(@ModelAttribute Role role) {
        roleService.createRole(role);
        return "redirect:/roles";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("role",
                roleService.getRoleById(id).orElseThrow(() -> new RuntimeException("Not found")));
        return "roles/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Role role) {
        roleService.updateRole(id, role);
        return "redirect:/roles";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        roleService.deleteRole(id);
        return "redirect:/roles";
    }
}
