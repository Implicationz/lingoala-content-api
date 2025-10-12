package com.lingoala.content.repository;

import com.lingoala.content.domain.*;
import org.springframework.data.jpa.domain.Specification;

public class LibraryEntrySpecifications {

    public static Specification<LibraryEntry> hasSubject(Subject subject) {
        return (root, query, cb) -> subject == null ? null : cb.equal(root.get("content").get("subject"), subject);
    }

    public static Specification<LibraryEntry> hasTopic(Topic topic) {
        return (root, query, cb) -> topic == null ? null : cb.equal(root.get("content").get("topic"), topic);
    }

    public static Specification<LibraryEntry> hasLibrary(Library library) {
        return (root, query, cb) -> library == null ? null : cb.equal(root.get("library"), library);
    }

    public static Specification<LibraryEntry> hasType(ContentType type) {
        return (root, query, cb) -> type == null ? null : cb.equal(root.get("content").get("type"), type);
    }
}
