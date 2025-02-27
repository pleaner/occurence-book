set search_path = occurrence_book;

CREATE TABLE profiles
(
    id                 BIGSERIAL PRIMARY KEY,
    user_id            BIGINT references users (id),
    organisation_id    BIGINT references organisations (id),
    title              VARCHAR(255),
    first_name         VARCHAR(255),
    last_name          VARCHAR(255),
    external_reference VARCHAR(255),
    picture_url        VARCHAR(255),
    status             SMALLINT,
    selected           BOOLEAN DEFAULT FALSE NOT NULL,
    created_at         TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE users_profiles
(
    user_id    BIGINT references users (id),
    profile_id BIGINT references profiles (id)
);
