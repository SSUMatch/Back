package com.Main.domain.user.domain.service;

import org.springframework.stereotype.Service;

@Service
public class GradeFormatter {

    public String calculateGrade(Integer score) {
        return switch (score / 100) {
            case 0 -> "비기너";
            case 1 -> "아마추어";
            case 2 -> "세미 프로";
            case 3 -> "프로";
            case 4 -> "월드 클래스";
            default -> "챌린저";
        };
    }
}
