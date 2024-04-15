-- liquibase formatted sql
-- changeset Vasiliy:10

ALTER TABLE saved_filter
    DROP COLUMN notification_sent;