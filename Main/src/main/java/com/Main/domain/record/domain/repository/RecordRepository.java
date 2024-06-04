package com.Main.domain.record.domain.repository;

import com.Main.domain.record.domain.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {
    Record findByUserId(Long userId);
}
