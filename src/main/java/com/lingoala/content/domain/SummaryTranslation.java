package com.lingoala.content.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SummaryTranslation extends BaseEntity {


    @ManyToOne
    private Summary summary;

    private LanguageCode language;

    @Column(columnDefinition = "TEXT")
    private String text;
}