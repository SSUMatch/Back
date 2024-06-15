package com.Main.domain.user.domain.service;

import com.Main.domain.user.domain.entity.User;
import com.Main.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserModifier {
    private final UserRepository userRepository;
    public User saveUser(User user){
        return userRepository.save(user);
    }
}
