package com.Main.domain.user.application.service;

import com.Main.domain.record.domain.entity.Record;
import com.Main.domain.user.application.dto.response.UserProfileResponse;
import com.Main.domain.user.domain.entity.User;
import com.Main.domain.user.domain.repository.UserRepository;
import com.Main.domain.user.domain.service.GradeFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final GradeFormatter gradeFormatter;

    public UserProfileResponse getUserProfile(Long userId) {
        User user = userRepository.findById(userId);

        Record record = user.getRecord();
        String grade;

        if (record != null) {
            grade = gradeFormatter.calculateGrade(record.getScore()); // 점수를 기반으로 등급 계산
        } else {
            grade = "비기너";
        }

        return UserProfileResponse.of(user, grade, record);
    }
}
