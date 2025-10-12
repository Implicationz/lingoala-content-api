package com.lingoala.content.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryContent extends BaseEntity {

    private String title;
    private String titleTranslation;
    private String titleTranscription;

    @ManyToOne
    private Subject subject;
    @ManyToOne
    private Topic topic;

    @Column(nullable = false)
    private LanguageCode language;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ContentType type;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private ContentDifficulty difficulty = ContentDifficulty.A1;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Visibility visibility = Visibility.PRIVATE;

    private String ownerId;

    private int estimatedDuration;

    private String image;

    @OneToOne(cascade = CascadeType.ALL)
    private LibraryMaterial material;


    @BatchSize(size = 30)
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LibraryContentPart> parts;
}