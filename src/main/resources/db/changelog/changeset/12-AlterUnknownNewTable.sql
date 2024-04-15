-- liquibase formatted sql
-- changeset Vasiliy:12

ALTER TABLE unknown_new_events
    ADD COLUMN event_id BIGINT;