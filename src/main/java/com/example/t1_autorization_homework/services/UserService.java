package com.example.t1_autorization_homework.services;

import com.example.t1_autorization_homework.models.Role;
import com.example.t1_autorization_homework.models.User;
import com.example.t1_autorization_homework.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User createUser(User user){
        if (userRepository.existsByUsername(user.getUsername())){
            throw new RuntimeException("Пользователь с таким логином уже существует");
        }

        if (userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("Пользователь с таким адресом электронной почты уже существует");
        }

        return saveUser(user);
    }

    public User getByUsername(String username){
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
    }

    public UserDetailsService userDetailsService(){
        return this::getByUsername;
    }

    public User getCurrentUser(){
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }

    @Deprecated
    public void getAdmin(){
        var user = getCurrentUser();
        user.setRole(Role.ROLE_ADMIN);
        saveUser(user);
    }
}
