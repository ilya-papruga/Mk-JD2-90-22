CREATE DATABASE university;

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

CREATE SCHEMA main;


SET default_tablespace = '';

SET default_table_access_method = heap;

CREATE TABLE main.cross_group_student (
    group_id bigint,
    student_id bigint
);

CREATE TABLE main."group" (
    id bigint NOT NULL,
    number character varying
);


CREATE SEQUENCE main.group_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE main.group_id_seq OWNED BY main."group".id;

CREATE TABLE main.students (
    id bigint NOT NULL,
    name character varying,
    age bigint,
    score double precision,
    olympic_gamer boolean
);

CREATE SEQUENCE main.students_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE main.students_id_seq OWNED BY main.students.id;

ALTER TABLE ONLY main."group" ALTER COLUMN id SET DEFAULT nextval('main.group_id_seq'::regclass);

ALTER TABLE ONLY main.students ALTER COLUMN id SET DEFAULT nextval('main.students_id_seq'::regclass);

ALTER TABLE ONLY main."group"
    ADD CONSTRAINT group_pkey PRIMARY KEY (id);

ALTER TABLE ONLY main.students
    ADD CONSTRAINT students_pkey PRIMARY KEY (id);
