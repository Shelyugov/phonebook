CREATE DATABASE IF NOT EXISTS phonebook_database;

CREATE SEQUENCE personal_data_sequence;

CREATE TABLE personal_data (
    id INTEGER PRIMARY KEY DEFAULT NEXTVAL('personal_data_sequence'),
    name CHARACTER VARYING (64),
    surname CHARACTER VARYING (64)
);

CREATE SEQUENCE phonebook_entry_sequence;

CREATE TABLE phonebook_entry (
    id INTEGER PRIMARY KEY DEFAULT NEXTVAL('phonebook_entry_sequence'),
    personal_data_id INTEGER UNIQUE NOT NULL REFERENCES personal_data(id)
);

CREATE SEQUENCE phone_number_sequence;

CREATE TABLE phone_number (
    id INTEGER PRIMARY KEY DEFAULT NEXTVAL('phone_number_sequence'),
    number CHARACTER VARYING (64) UNIQUE,
    phone_number_type CHARACTER (4),
    phonebook_entry_id INTEGER NOT NULL REFERENCES phonebook_entry(id)
);