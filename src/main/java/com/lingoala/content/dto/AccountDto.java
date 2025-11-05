package com.lingoala.content.dto;

import com.lingoala.content.domain.AccessLevel;
import com.lingoala.content.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountDto {

    private UUID userId;
    @Builder.Default
    private AccessLevel accessLevel = AccessLevel.FREE;

}