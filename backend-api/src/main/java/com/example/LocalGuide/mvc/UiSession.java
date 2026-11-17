package com.example.LocalGuide.mvc;

import javax.security.auth.login.LoginException;

import jakarta.servlet.http.HttpSession;


final class UiSession {
    public UiSession() {
    }

    static Long requireId (HttpSession session, String role) throws LoginException {
        Object id = session.getAttribute("userId");
        Object currentRole = session.getAttribute("role");
        if (!(id instanceof Long userId) || !role.equals(currentRole)) {
            throw new LoginException("Please log in to continue.");
        }
        return userId;
    }

}
