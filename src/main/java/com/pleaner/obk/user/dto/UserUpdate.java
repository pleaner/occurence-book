package com.pleaner.obk.user.dto;

import java.util.UUID;

public record UserUpdate(
    String username,
    String passwordHash,
    UserState state,
    UUID activeProfile
) {
}
