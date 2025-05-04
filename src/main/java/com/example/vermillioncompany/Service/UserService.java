package com.example.vermillioncompany.Service;

import com.example.vermillioncompany.Model.User;
import com.example.vermillioncompany.Repository.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo repo;
    private final PasswordEncoder encoder;

    public UserService(UserRepo repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    public void registerUser(User user) {
        // Обязательно должно быть кодирование!
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
    }
}
