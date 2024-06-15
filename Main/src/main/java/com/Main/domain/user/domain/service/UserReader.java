package com.Main.domain.user.domain.service;

import com.Main.domain.user.application.dto.request.SignUpRequest;
import com.Main.domain.user.domain.entity.User;
import com.Main.domain.user.domain.repository.UserRepository;
import com.Main.global.error.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.Main.global.error.status.ErrorStatus.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserReader {
    private final UserRepository userRepository;
    public User findById(Long userId){
        return userRepository.findById(userId).orElseThrow(()-> new GeneralException(USER_NOT_FOUND));
    }
    public User getUserByIdAndPassword(SignUpRequest signUpRequest) {
        Optional<User> optionalUser = userRepository.findByAccountAndPassword(signUpRequest.id(), signUpRequest.password());
        return optionalUser.orElseGet(() -> User.createUser(signUpRequest));
    }
    public User getUserByIdAndPassword2(String account, String password) {
        return userRepository.findByAccountAndPassword(account, password).orElseThrow();
    }
}
