package com.Main.domain.match.application.controller;

import com.Main.domain.match.application.dto.SimpleMatchInfoResponse;
import com.Main.domain.match.application.service.MatchService;
import com.Main.global.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/match")
@RequiredArgsConstructor
public class MatchController {
     private final MatchService matchService;
     @GetMapping
     ApiResponse<List<SimpleMatchInfoResponse>> getMatchList(@RequestParam(name = "date") String date){
          final List<SimpleMatchInfoResponse> simpleMatchInfoResponses = matchService.getMatchInfoList(date);
          return ApiResponse.onSuccess(simpleMatchInfoResponses);
     }
}
