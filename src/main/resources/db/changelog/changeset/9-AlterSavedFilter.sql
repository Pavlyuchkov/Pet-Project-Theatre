-- liquibase formatted sql
-- changeset Vasiliy:9

ALTER TABLE saved_filter
    DROP COLUMN venue_id;