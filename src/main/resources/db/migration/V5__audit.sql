set search_path = occurrence_book;

CREATE TABLE audit_log
(
    id           BIGSERIAL PRIMARY KEY,
    done_by      BIGINT REFERENCES users (id) NOT NULL,
    subject_id   BIGINT                       NOT NULL,
    subject_type VARCHAR(20),
    occurred_at  TIMESTAMP WITHOUT TIME ZONE DEFAULT current_timestamp,
    description  TEXT
);

CREATE INDEX idx_audit_log_done_by ON audit_log (done_by);
CREATE INDEX idx_audit_log_subject ON audit_log (subject_type, subject_id);