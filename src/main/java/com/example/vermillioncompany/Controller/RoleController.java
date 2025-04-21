package com.example.vermillioncompany.Controller;

import com.example.vermillioncompany.Model.Role;
import com.example.vermillioncompany.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/roles")
public class RoleController {

    private RoleService rs;

    @Autowired
    public RoleController(RoleService rs) {
        this.rs = rs;
    }

    @GetMapping
    public List<Role> all() {
        return rs.getAllRoles();
    }

    @GetMapping("/{id}")
    public Optional<Role> get(@PathVariable Long id) {
        return rs.getRoleById(id);
    }

    @PostMapping
    public Role create(@RequestBody Role r) {
        return rs.createRole(r);
    }

    @PutMapping("/{id}")
    public Role update(@PathVariable Long id, @RequestBody Role r) {
        return rs.updateRole(id, r);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        rs.deleteRole(id);
    }
}
