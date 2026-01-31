package com.lingoala.content.client;

import com.lingoala.gamification.dto.GoalDto;
import com.lingoala.gamification.dto.GoalTypeDto;
import com.lingoala.gamification.dto.GoalZoneDto;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@Slf4j
public class GamificationClientFallback implements GamificationClient {

    @Override
    public List<GoalDto> getGoals(String zone, String type, List<String> references) {
        log.warn("Fallback getGoals called for zone={}, type={} - returning empty list", zone, type);
        return Collections.emptyList();
    }

    @Override
    public GoalTypeDto createType(GoalTypeDto typeDto) {
        log.warn("Fallback createType called - returning null");
        return null;
    }

    @Override
    public GoalZoneDto createZone(GoalZoneDto zoneDto) {
        log.warn("Fallback createZone called - returning null");
        return null;
    }
}
