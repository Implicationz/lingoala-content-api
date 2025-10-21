package com.lingoala.content.repository;

import com.lingoala.content.domain.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.concurrent.ThreadLocalRandom;

public class LibraryContentSpecifications {

    public static Specification<LibraryContent> hasLanguage(LanguageCode language) {
        return (root, query, cb) -> language == null ? null : cb.equal(root.get("language"), language);
    }

    public static Specification<LibraryContent> hasSubject(Subject subject) {
        return (root, query, cb) -> subject == null ? null : cb.equal(root.get("subject"), subject);
    }

    public static Specification<LibraryContent> hasTopic(Topic topic) {
        return (root, query, cb) -> topic == null ? null : cb.equal(root.get("topic"), topic);
    }

    public static Specification<LibraryContent> hasType(ContentType type) {
        return (root, query, cb) -> type == null ? null : cb.equal(root.get("type"), type);
    }

    public static Specification<LibraryContent> randomOrder() {
        final var seed = ThreadLocalRandom.current().nextDouble();
        return (root, query, cb) -> {
            query.orderBy(
                    cb.asc(cb.abs(cb.diff(root.get("randomSeed"), seed)))
            );
            return cb.conjunction();
        };
    }

    public static Specification<LibraryContent> createdOrder() {
        return (root, query, cb) -> {
            query.orderBy(cb.desc(root.get("createdAt")));
            return cb.conjunction();
        };
    }
}
