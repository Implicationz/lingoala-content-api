package com.lingoala.content.dto;

import com.lingoala.content.domain.LibraryContent;
import com.lingoala.gamification.dto.GoalDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContentCarouselSlideDto {
    private LibraryContentDto libraryContent;
    private GoalDto goal;
}
