package com.lingoala.gamification.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class ObjectiveDto {
    private GoalDto parent;
    private GoalDto child;
}