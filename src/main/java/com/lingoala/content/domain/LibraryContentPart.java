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
public class LibraryContentPart extends BaseEntity {

    @ManyToOne
    private LibraryContent parent;

    private int position;

    @ManyToOne
    private LibraryContent child;

}