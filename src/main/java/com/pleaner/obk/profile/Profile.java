package com.pleaner.obk.profile;

import java.util.UUID;

public record Profile (
    UUID uuid,
    UUID userUuid,
    UUID organisationUuid,
    String title,
    String firstname,
    String lastname,
    String external_reference,
    String pictureUrl,
    ProfileStatus status
) {
}