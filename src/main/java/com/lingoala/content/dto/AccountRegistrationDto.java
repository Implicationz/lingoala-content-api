package com.lingoala.content.dto;

import com.lingoala.content.domain.AccessLevel;
import lombok.*;

import java.util.UUID;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountRegistrationDto {

    private String name;
    @Builder.Default
    private AccessLevel accessLevel = AccessLevel.FREE;

}