package com.Main.domain.user.service;

import com.Main.domain.user.entity.User;
import com.Main.domain.user.repository.UserRepository;
import com.Main.global.error.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.Main.global.error.status.ErrorStatus.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserReader {
    private final UserRepository userRepository;
    public User findById(Long userId){
        return userRepository.findById(userId).orElseThrow(()-> new GeneralException(USER_NOT_FOUND));
    }
}
