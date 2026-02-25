package com.lingoala.content.client;

import com.lingoala.content.configuration.FeignClientConfiguration;
import com.lingoala.content.domain.LanguageCode;
import com.lingoala.gamification.dto.GoalDto;
import com.lingoala.gamification.dto.GoalTypeDto;
import com.lingoala.gamification.dto.GoalZoneDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
        name = "gamification-service",
        url = "${lingoala.gamification.client.url}",
        configuration = FeignClientConfiguration.class,
        fallback = GamificationClientFallback.class
)
public interface GamificationClient {
    @GetMapping("/goal")
    List<GoalDto> getGoals(
            @RequestParam("zone") String zone,
            @RequestParam("type") String type,
            @RequestParam(value = "references", required = false) List<String> references,
            @RequestParam(value = "isCompleted", required = false) Boolean isCompleted
    );

    @PostMapping("/goal-type")
    GoalTypeDto createType(@RequestBody GoalTypeDto typeDto);

    @PostMapping("/goal-zone")
    GoalZoneDto createZone(@RequestBody GoalZoneDto zoneDto);

    default List<GoalDto> getIncompleteLibraryContentGoals(LanguageCode code) {
        return getLibraryContentGoals(code, null, false);
    }

    default List<GoalDto> getLibraryContentGoals(LanguageCode code, List<String> references) {
        return getLibraryContentGoals(code, references, null);
    }

    default List<GoalDto> getLibraryContentGoals(LanguageCode code, List<String> references, Boolean isCompleted) {
        return getGoals(code.getValue(), "library-content", references, isCompleted);
    }
}