set search_path = occurrence_book;

CREATE TABLE organisations
(
    id         SERIAL PRIMARY KEY,
    full_name  VARCHAR(255),
    short_name VARCHAR(100),
    logo_url   VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);