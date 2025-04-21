package com.example.vermillioncompany.Service;

import com.example.vermillioncompany.Model.Role;
import com.example.vermillioncompany.Repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepo roleRepo;

    @Autowired
    public RoleService(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public List<Role> getAllRoles() {
        return roleRepo.findAll();
    }

    public Optional<Role> getRoleById(Long id) {
        return roleRepo.findById(id);
    }

    public Role createRole(Role role) {
        return roleRepo.save(role);
    }

    public Role updateRole(Long id, Role updatedRole) {
        return roleRepo.findById(id).map(r -> {
            r.setRoleName(updatedRole.getRoleName());
            r.setDevelopers(updatedRole.getDevelopers());
            return roleRepo.save(r);
        }).orElseThrow(() -> new RuntimeException("Роль не найдена с id: " + id));
    }

    public void deleteRole(Long id) {
        roleRepo.deleteById(id);
    }
}
