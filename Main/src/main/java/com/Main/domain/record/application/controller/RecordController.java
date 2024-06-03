package com.Main.domain.record.application.controller;

import com.Main.domain.match.application.dto.MatchDetailResponse;
import com.Main.domain.record.application.dto.RecordResponseDto;
import com.Main.domain.record.application.service.RecordService;
import com.Main.global.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/record")
@RestController
@RequiredArgsConstructor
public class RecordController {
    private final RecordService recordService;
    @GetMapping
    ApiResponse<List<RecordResponseDto>> getRecord(@RequestParam(name = "userId")Long userId){
        final List<RecordResponseDto> recordResponseDtos = recordService.getUserRecord(userId);
        return ApiResponse.onSuccess(recordResponseDtos);
    }
}
