package com.lingoala.content.domain;

import com.lingoala.gamification.dto.GoalDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryCarouselSlide {
    private LibraryEntry entry;
    private GoalDto goal;
}
