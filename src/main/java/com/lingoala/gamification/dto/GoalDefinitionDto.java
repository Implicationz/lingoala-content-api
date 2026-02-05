package com.lingoala.gamification.dto;

import lombok.Data;

import java.util.List;

@Data
public class GoalDefinitionDto {
    private Long id;
    private String reference;
    private GoalTypeDto type;
    private GoalZoneDto zone;
    private long target;
    private List<ObjectiveDefinitionDto> objectives;
}