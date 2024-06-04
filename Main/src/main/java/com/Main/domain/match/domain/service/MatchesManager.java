package com.Main.domain.match.domain.service;

import com.Main.domain.record.domain.entity.Record;
import com.Main.domain.user.domain.entity.User;
import com.Main.domain.userMatch.domain.entity.UserMatch;

import java.util.List;

public interface MatchesManager {
    String isFull(Long matchesId);
    String getExpectRate(List<Record> user);
}
