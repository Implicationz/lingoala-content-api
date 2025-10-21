package com.lingoala.content.dto;

import com.lingoala.content.domain.LibraryContent;
import com.lingoala.gamification.dto.GoalDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContentSearchHitDto {
    private LibraryContentDto content;
    private GoalDto goal;
}
