package com.example.LocalGuide.mvc;

import jakarta.servlet.http.HttpSession;

final class UiSession {
    public UiSession() {
    }

    static Long requireId(HttpSession session, String role) {
        Object id = session.getAttribute("userId");
        if (!(id instanceof Long userId)) {
            throw new IllegalStateException("User must be logged in.");
        }
        return userId;
    }

}
