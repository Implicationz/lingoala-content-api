package com.lingoala.gamification.dto;

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class GoalDto {
    private Long id;
    private GoalDefinitionDto definition;
    private Instant lastProgress;
    private List<ObjectiveDto> objectives;
}