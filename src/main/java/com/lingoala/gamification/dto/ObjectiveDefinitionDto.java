package com.lingoala.gamification.dto;

import lombok.Data;

@Data
public class ObjectiveDefinitionDto {
    private GoalDefinitionDto parent;
    private GoalDefinitionDto child;
}