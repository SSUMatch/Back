package com.Main.domain.match.application.controller;

import com.Main.domain.match.application.dto.MatchDetailResponse;
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
     ApiResponse<List<SimpleMatchInfoResponse>> getMatchList(@RequestParam(name = "page") int page, @RequestParam(name = "take") int take, @RequestParam(name = "date") String date){
          final List<SimpleMatchInfoResponse> simpleMatchInfoResponses = matchService.getMatchInfoList(page, take, date);
          return ApiResponse.onSuccess(simpleMatchInfoResponses);
     }
     @GetMapping("/detail")
     ApiResponse<MatchDetailResponse> getMatchDetail(@RequestParam(name = "matchId")Long matchId){
          final MatchDetailResponse matchDetailResponse = matchService.getMatchDetail(matchId);
          return ApiResponse.onSuccess(matchDetailResponse);
     }
}
