package com.lingoala.content.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryContent extends AuditAwareEntity {

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

    @ManyToOne
    private Account owner;

    private Double randomSeed;

    private int estimatedDuration;

    private String image;

    private Instant publishedAt;

    @OneToOne(cascade = CascadeType.ALL)
    private LibraryMaterial material;

    @BatchSize(size = 10)
    @OneToMany(mappedBy = "child", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LibraryContentPart> partOf;

    @BatchSize(size = 100)
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LibraryContentPart> parts;

    @PrePersist
    protected void onContentPersist() {
        if (randomSeed == null)
            randomSeed = ThreadLocalRandom.current().nextDouble();
    }


}