package com.lingoala.content.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibrarySearch {
    private Library library;
    private Subject subject;
    private Topic topic;
    private List<LibrarySearchHit> hits;
}
