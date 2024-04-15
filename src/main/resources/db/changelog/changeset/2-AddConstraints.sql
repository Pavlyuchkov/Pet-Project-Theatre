-- liquibase formatted sql
-- changeset Vasiliy:2

ALTER TABLE event_table
    add constraint const unique (event_id, source);