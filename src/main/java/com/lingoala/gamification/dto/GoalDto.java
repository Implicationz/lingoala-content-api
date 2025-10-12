package com.lingoala.gamification.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class GoalDto {
    private Long id;
    private GoalDefinitionDto definition;
    private Instant lastProgress;
}