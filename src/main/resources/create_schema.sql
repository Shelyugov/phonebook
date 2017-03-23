-- Скрипт для создания и настройки базы данных.

CREATE DATABASE IF NOT EXISTS phonebook_database;

CREATE SEQUENCE personal_data_sequence;

CREATE TABLE personal_data (
    id BIGINT PRIMARY KEY DEFAULT NEXTVAL('personal_data_sequence'),
    name CHARACTER VARYING (64),
    surname CHARACTER VARYING (64)
);

CREATE SEQUENCE phonebook_entry_sequence;

CREATE TABLE phonebook_entry (
    id BIGINT PRIMARY KEY DEFAULT NEXTVAL('phonebook_entry_sequence'),
    person_id BIGINT UNIQUE NOT NULL REFERENCES personal_data(id)
);

CREATE SEQUENCE phone_number_sequence;

CREATE TABLE phone_number (
    id BIGINT PRIMARY KEY DEFAULT NEXTVAL('phone_number_sequence'),
    number CHARACTER VARYING (64) UNIQUE,
    phone_number_type VARCHAR (4),
    entry_id BIGINT NOT NULL REFERENCES phonebook_entry(id)
);

CREATE USER phonebook_user WITH PASSWORD 'password';
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO phonebook_user;

-- DROP TABLE phone_number;
-- DROP SEQUENCE phone_number_sequence;
-- DROP TABLE phonebook_entry;
-- DROP SEQUENCE phonebook_entry_sequence;
-- DROP TABLE personal_data;
-- DROP SEQUENCE personal_data_sequence;