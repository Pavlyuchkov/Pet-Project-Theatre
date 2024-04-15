-- liquibase formatted sql
-- changeset Vasiliy:6

ALTER TABLE event_table
    ADD CONSTRAINT event_id UNIQUE (event_id);

ALTER TABLE saved_filter
    ADD FOREIGN KEY (event_id) REFERENCES event_table(event_id);