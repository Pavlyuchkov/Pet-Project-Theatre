-- liquibase formatted sql
-- changeset Vasiliy:8

ALTER TABLE saved_filter
    ADD COLUMN event_name_id BIGINT;