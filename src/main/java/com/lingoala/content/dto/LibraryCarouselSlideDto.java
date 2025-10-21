package com.lingoala.content.dto;

import com.lingoala.content.domain.LibraryEntry;
import com.lingoala.gamification.dto.GoalDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryCarouselSlideDto {
    private LibraryEntryDto entry;
    private GoalDto goal;
}
