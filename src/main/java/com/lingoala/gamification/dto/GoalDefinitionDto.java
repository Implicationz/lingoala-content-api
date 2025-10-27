package com.lingoala.gamification.dto;

import lombok.Data;

import java.util.List;

@Data
public class GoalDefinitionDto {
    private Long id;
    private String reference;
    private long target;
    private List<ObjectiveDefinitionDto> objectives;
}