package com.lingoala.content.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryEntry extends AuditAwareEntity {

    @ManyToOne(optional = false)
    private Library library;

    @ManyToOne(optional = false)
    private LibraryContent content;

}