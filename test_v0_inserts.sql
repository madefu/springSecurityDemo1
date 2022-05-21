--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2
-- Dumped by pg_dump version 14.2

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

--
-- Name: test_v0; Type: SCHEMA; Schema: -; Owner: madefu
--

CREATE SCHEMA test_v0;


ALTER SCHEMA test_v0 OWNER TO madefu;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: t_user_account_detail; Type: TABLE; Schema: test_v0; Owner: madefu
--

CREATE TABLE test_v0.t_user_account_detail (
    id bigint NOT NULL,
    user_id bigint NOT NULL,
    age smallint,
    address character varying
);


ALTER TABLE test_v0.t_user_account_detail OWNER TO madefu;

--
-- Name: User_detail_id_seq; Type: SEQUENCE; Schema: test_v0; Owner: madefu
--

CREATE SEQUENCE test_v0."User_detail_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE test_v0."User_detail_id_seq" OWNER TO madefu;

--
-- Name: User_detail_id_seq; Type: SEQUENCE OWNED BY; Schema: test_v0; Owner: madefu
--

ALTER SEQUENCE test_v0."User_detail_id_seq" OWNED BY test_v0.t_user_account_detail.id;


--
-- Name: t_user_account; Type: TABLE; Schema: test_v0; Owner: madefu
--

CREATE TABLE test_v0.t_user_account (
    id bigint NOT NULL,
    user_name character varying(32) NOT NULL,
    password character varying(64) NOT NULL,
    create_at timestamp with time zone DEFAULT now(),
    update_at timestamp with time zone DEFAULT now(),
    personal_info jsonb,
    sex_enum smallint DEFAULT 0 NOT NULL
);


ALTER TABLE test_v0.t_user_account OWNER TO madefu;

--
-- Name: User_id_seq; Type: SEQUENCE; Schema: test_v0; Owner: madefu
--

CREATE SEQUENCE test_v0."User_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE test_v0."User_id_seq" OWNER TO madefu;

--
-- Name: User_id_seq; Type: SEQUENCE OWNED BY; Schema: test_v0; Owner: madefu
--

ALTER SEQUENCE test_v0."User_id_seq" OWNED BY test_v0.t_user_account.id;


--
-- Name: t1; Type: TABLE; Schema: test_v0; Owner: madefu
--

CREATE TABLE test_v0.t1 (
    id integer NOT NULL,
    house_name character varying,
    height_int4 integer,
    column_int8 bigint,
    column_smallint smallint,
    column_bool_flag boolean,
    column_timestamptz timestamp with time zone,
    column_timestamp timestamp without time zone,
    column_json json,
    column_jsonb jsonb,
    column_text text,
    cidr cidr,
    column_decimal numeric(10,4)
);


ALTER TABLE test_v0.t1 OWNER TO madefu;

--
-- Name: t1_id_seq; Type: SEQUENCE; Schema: test_v0; Owner: madefu
--

CREATE SEQUENCE test_v0.t1_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE test_v0.t1_id_seq OWNER TO madefu;

--
-- Name: t1_id_seq; Type: SEQUENCE OWNED BY; Schema: test_v0; Owner: madefu
--

ALTER SEQUENCE test_v0.t1_id_seq OWNED BY test_v0.t1.id;


--
-- Name: t1 id; Type: DEFAULT; Schema: test_v0; Owner: madefu
--

ALTER TABLE ONLY test_v0.t1 ALTER COLUMN id SET DEFAULT nextval('test_v0.t1_id_seq'::regclass);


--
-- Name: t_user_account id; Type: DEFAULT; Schema: test_v0; Owner: madefu
--

ALTER TABLE ONLY test_v0.t_user_account ALTER COLUMN id SET DEFAULT nextval('test_v0."User_id_seq"'::regclass);


--
-- Name: t_user_account_detail id; Type: DEFAULT; Schema: test_v0; Owner: madefu
--

ALTER TABLE ONLY test_v0.t_user_account_detail ALTER COLUMN id SET DEFAULT nextval('test_v0."User_detail_id_seq"'::regclass);


--
-- Data for Name: t1; Type: TABLE DATA; Schema: test_v0; Owner: madefu
--



--
-- Data for Name: t_user_account; Type: TABLE DATA; Schema: test_v0; Owner: madefu
--

INSERT INTO test_v0.t_user_account VALUES (1, 'madefu', '$2a$10$f2JKF90adCwOtzlQkUpJZ.9YDjVJtdJ1PBKD4VJs/NTbY7JRN1gDW', NULL, NULL, NULL, 0);


--
-- Data for Name: t_user_account_detail; Type: TABLE DATA; Schema: test_v0; Owner: madefu
--



--
-- Name: User_detail_id_seq; Type: SEQUENCE SET; Schema: test_v0; Owner: madefu
--

SELECT pg_catalog.setval('test_v0."User_detail_id_seq"', 1, false);


--
-- Name: User_id_seq; Type: SEQUENCE SET; Schema: test_v0; Owner: madefu
--

SELECT pg_catalog.setval('test_v0."User_id_seq"', 1, true);


--
-- Name: t1_id_seq; Type: SEQUENCE SET; Schema: test_v0; Owner: madefu
--

SELECT pg_catalog.setval('test_v0.t1_id_seq', 1, false);


--
-- Name: t1 t1_pk; Type: CONSTRAINT; Schema: test_v0; Owner: madefu
--

ALTER TABLE ONLY test_v0.t1
    ADD CONSTRAINT t1_pk PRIMARY KEY (id);


--
-- Name: t_user_account_detail user_detail_pk; Type: CONSTRAINT; Schema: test_v0; Owner: madefu
--

ALTER TABLE ONLY test_v0.t_user_account_detail
    ADD CONSTRAINT user_detail_pk PRIMARY KEY (id);


--
-- Name: t_user_account user_pk; Type: CONSTRAINT; Schema: test_v0; Owner: madefu
--

ALTER TABLE ONLY test_v0.t_user_account
    ADD CONSTRAINT user_pk PRIMARY KEY (id);


--
-- Name: user_user_name_uindex; Type: INDEX; Schema: test_v0; Owner: madefu
--

CREATE UNIQUE INDEX user_user_name_uindex ON test_v0.t_user_account USING btree (user_name);


--
-- Name: t_user_account_detail user_detail_user_id_fk; Type: FK CONSTRAINT; Schema: test_v0; Owner: madefu
--

ALTER TABLE ONLY test_v0.t_user_account_detail
    ADD CONSTRAINT user_detail_user_id_fk FOREIGN KEY (user_id) REFERENCES test_v0.t_user_account(id);


--
-- Name: SCHEMA test_v0; Type: ACL; Schema: -; Owner: madefu
--

GRANT ALL ON SCHEMA test_v0 TO PUBLIC;
GRANT ALL ON SCHEMA test_v0 TO pg_database_owner;


--
-- Name: TABLE t_user_account_detail; Type: ACL; Schema: test_v0; Owner: madefu
--

GRANT ALL ON TABLE test_v0.t_user_account_detail TO PUBLIC;


--
-- Name: TABLE t_user_account; Type: ACL; Schema: test_v0; Owner: madefu
--

GRANT ALL ON TABLE test_v0.t_user_account TO PUBLIC;


--
-- Name: TABLE t1; Type: ACL; Schema: test_v0; Owner: madefu
--

GRANT ALL ON TABLE test_v0.t1 TO PUBLIC;


--
-- PostgreSQL database dump complete
--

