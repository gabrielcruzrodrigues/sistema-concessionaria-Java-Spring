package com.example.sistema.services.user;

import com.example.sistema.models.user.RegisterDTO;
import com.example.sistema.models.user.User;
import com.example.sistema.repositories.UserRepository;
import com.example.sistema.services.exceptions.UserAlreadyExistException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User create(RegisterDTO user) {
        checksIfUserAlreadyExists(user.login());
        String encryptedPassword = new BCryptPasswordEncoder().encode(user.password());
        User newUser = new User(user.login(), encryptedPassword, user.role());
        return this.userRepository.save(newUser);
    }

    public void checksIfUserAlreadyExists(String login) {
        UserDetails user = userRepository.findByLogin(login);
        if (user != null) throw new UserAlreadyExistException("Usuário ja consta no banco de dados! login: " + login);
    }
}
