package com.lingoala.content.repository;

import com.lingoala.content.domain.*;
import org.springframework.data.jpa.domain.Specification;

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
}
