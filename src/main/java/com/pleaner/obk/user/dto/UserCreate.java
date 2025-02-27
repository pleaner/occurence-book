package com.pleaner.obk.user.dto;

import java.util.UUID;

public record UserCreate(
    String username,
    String passwordHash,
    UserState state,
    UUID activeProfile
) { }
