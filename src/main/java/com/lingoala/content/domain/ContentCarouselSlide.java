package com.lingoala.content.domain;

import com.lingoala.gamification.dto.GoalDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContentCarouselSlide {
    private LibraryContent libraryContent;
    private GoalDto goal;
}
