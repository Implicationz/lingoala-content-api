package com.lingoala.content.domain.listener;

import com.lingoala.content.domain.LibraryContent;
import com.lingoala.content.service.UserService;
import jakarta.persistence.PrePersist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibraryContentListener {

    private static UserService userService;

    @Autowired
    public void init(UserService userService) {
        LibraryContentListener.userService = userService;
    }

    @PrePersist
    public void setOwnerId(LibraryContent content) {
        if (content.getOwnerId() == null) {
            content.setOwnerId(userService.getCurrentUserId());
        }
    }
}
