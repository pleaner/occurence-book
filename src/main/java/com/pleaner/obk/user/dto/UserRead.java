package com.pleaner.obk.user.dto;

public record UserRead(
    long id,
    String username,
    UserState state,
    long activeProfile) {
}