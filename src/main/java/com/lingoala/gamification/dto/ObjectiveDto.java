package com.lingoala.gamification.dto;

import lombok.Data;

@Data
public class ObjectiveDto {
    private GoalDto parent;
    private GoalDto child;
}