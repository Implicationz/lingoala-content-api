package com.lingoala.content.domain;

import com.lingoala.gamification.dto.GoalDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContentCarouselSlide {
    private LibraryContent libraryContent;
    private GoalDto goal;
}
