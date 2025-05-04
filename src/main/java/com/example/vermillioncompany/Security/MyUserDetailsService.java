package com.example.vermillioncompany.Security;

import com.example.vermillioncompany.Model.User;
import com.example.vermillioncompany.Repository.UserRepo;
import org.apache.catalina.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepo repo;

    @Autowired
    public MyUserDetailsService(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = repo.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException(username);

        return org.springframework.security.core.userdetails.User // ← Полное имя!
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities("USER")
                .build();
    }
}

