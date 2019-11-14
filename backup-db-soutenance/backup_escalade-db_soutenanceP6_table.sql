--
-- PostgreSQL database dump
--

-- Dumped from database version 10.10 (Ubuntu 10.10-1.pgdg18.04+1)
-- Dumped by pg_dump version 12.0 (Ubuntu 12.0-2.pgdg18.04+1)

-- Started on 2019-11-12 22:04:23 CET



--
-- TOC entry 196 (class 1259 OID 59475)
-- Name: account; Type: TABLE; Schema: public; Owner: nanoo
--

CREATE TABLE public.account (
                                id integer NOT NULL,
                                city character varying(30),
                                date_of_creation timestamp without time zone NOT NULL,
                                date_of_update timestamp without time zone NOT NULL,
                                firstname character varying(30) NOT NULL,
                                lastname character varying(30) NOT NULL,
                                mail character varying(30) NOT NULL,
                                password character varying(56) NOT NULL,
                                postal_code integer,
                                role_name character varying(13) NOT NULL,
                                street_name character varying(30),
                                title character varying(4) NOT NULL
);



--
-- TOC entry 197 (class 1259 OID 59480)
-- Name: commentary; Type: TABLE; Schema: public; Owner: nanoo
--

CREATE TABLE public.commentary (
                                   id integer NOT NULL,
                                   date_of_update timestamp without time zone NOT NULL,
                                   date_of_creation timestamp without time zone NOT NULL,
                                   id_account integer,
                                   id_type_of_comment integer,
                                   text character varying(300) NOT NULL,
                                   title character varying(30) NOT NULL
);



--
-- TOC entry 203 (class 1259 OID 59543)
-- Name: sector; Type: TABLE; Schema: public; Owner: nanoo
--

CREATE TABLE public.sector (
                               id integer NOT NULL,
                               date_of_creation timestamp without time zone NOT NULL,
                               date_of_update timestamp without time zone NOT NULL,
                               description character varying(300),
                               id_account integer NOT NULL,
                               name character varying(255) NOT NULL,
                               id_site integer NOT NULL
);



--
-- TOC entry 204 (class 1259 OID 59551)
-- Name: site; Type: TABLE; Schema: public; Owner: nanoo
--

CREATE TABLE public.site (
                             id integer NOT NULL,
                             date_of_creation timestamp without time zone NOT NULL,
                             date_of_update timestamp without time zone NOT NULL,
                             description character varying(300),
                             id_account integer NOT NULL,
                             name character varying(255) NOT NULL,
                             is_official_label boolean NOT NULL,
                             picture_path character varying(255),
                             region character varying(30) NOT NULL
);



--
-- TOC entry 205 (class 1259 OID 59559)
-- Name: topo; Type: TABLE; Schema: public; Owner: nanoo
--

CREATE TABLE public.topo (
                             id integer NOT NULL,
                             date_of_creation timestamp without time zone NOT NULL,
                             date_of_update timestamp without time zone NOT NULL,
                             description character varying(300),
                             id_account integer NOT NULL,
                             name character varying(255) NOT NULL,
                             condition character varying(10) NOT NULL,
                             date_of_publication date NOT NULL,
                             is_lendable boolean NOT NULL,
                             picture_path character varying(255),
                             region character varying(255) NOT NULL
);



--
-- TOC entry 198 (class 1259 OID 59509)
-- Name: topobooking; Type: TABLE; Schema: public; Owner: nanoo
--

CREATE TABLE public.topobooking (
                                    id integer NOT NULL,
                                    date_of_creation timestamp without time zone NOT NULL,
                                    date_of_expiry timestamp without time zone NOT NULL,
                                    date_of_update timestamp without time zone NOT NULL,
                                    id_account_borrower integer NOT NULL,
                                    id_account_owner integer NOT NULL,
                                    id_topo integer NOT NULL,
                                    owner_mail character varying(30),
                                    status character varying(10) NOT NULL
);



--
-- TOC entry 206 (class 1259 OID 59567)
-- Name: way; Type: TABLE; Schema: public; Owner: nanoo
--

CREATE TABLE public.way (
                            id integer NOT NULL,
                            date_of_creation timestamp without time zone NOT NULL,
                            date_of_update timestamp without time zone NOT NULL,
                            description character varying(300),
                            id_account integer NOT NULL,
                            name character varying(255) NOT NULL,
                            anchor_nbr integer,
                            height integer NOT NULL,
                            pitch_nbr integer,
                            rating character varying(20) NOT NULL,
                            rating_level integer NOT NULL,
                            id_sector integer NOT NULL
);




---------------------------------------------------------------
---------------------------------------------------------------


--
-- TOC entry 199 (class 1259 OID 59524)
-- Name: seq_account; Type: SEQUENCE; Schema: public; Owner: nanoo
--

CREATE SEQUENCE public.seq_account
    START WITH 10
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



--
-- TOC entry 200 (class 1259 OID 59526)
-- Name: seq_booking; Type: SEQUENCE; Schema: public; Owner: nanoo
--

CREATE SEQUENCE public.seq_booking
    START WITH 10
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



--
-- TOC entry 201 (class 1259 OID 59528)
-- Name: seq_commentary; Type: SEQUENCE; Schema: public; Owner: nanoo
--

CREATE SEQUENCE public.seq_commentary
    START WITH 20
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



--
-- TOC entry 202 (class 1259 OID 59530)
-- Name: seq_publication; Type: SEQUENCE; Schema: public; Owner: nanoo
--

CREATE SEQUENCE public.seq_publication
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



--
-- TOC entry 207 (class 1259 OID 59575)
-- Name: seq_sector; Type: SEQUENCE; Schema: public; Owner: nanoo
--

CREATE SEQUENCE public.seq_sector
    START WITH 1000
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



--
-- TOC entry 208 (class 1259 OID 59577)
-- Name: seq_site; Type: SEQUENCE; Schema: public; Owner: nanoo
--

CREATE SEQUENCE public.seq_site
    START WITH 100
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



--
-- TOC entry 209 (class 1259 OID 59579)
-- Name: seq_topo; Type: SEQUENCE; Schema: public; Owner: nanoo
--

CREATE SEQUENCE public.seq_topo
    START WITH 10000
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



--
-- TOC entry 210 (class 1259 OID 59581)
-- Name: seq_way; Type: SEQUENCE; Schema: public; Owner: nanoo
--

CREATE SEQUENCE public.seq_way
    START WITH 2000
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



---------------------------------------------------------------
---------------------------------------------------------------


--
-- TOC entry 2996 (class 0 OID 0)
-- Dependencies: 199
-- Name: seq_account; Type: SEQUENCE SET; Schema: public; Owner: nanoo
--

SELECT pg_catalog.setval('public.seq_account', 60, true);


--
-- TOC entry 2997 (class 0 OID 0)
-- Dependencies: 200
-- Name: seq_booking; Type: SEQUENCE SET; Schema: public; Owner: nanoo
--

SELECT pg_catalog.setval('public.seq_booking', 10, false);


--
-- TOC entry 2998 (class 0 OID 0)
-- Dependencies: 201
-- Name: seq_commentary; Type: SEQUENCE SET; Schema: public; Owner: nanoo
--

SELECT pg_catalog.setval('public.seq_commentary', 20, false);


--
-- TOC entry 2999 (class 0 OID 0)
-- Dependencies: 202
-- Name: seq_publication; Type: SEQUENCE SET; Schema: public; Owner: nanoo
--

SELECT pg_catalog.setval('public.seq_publication', 151, true);


--
-- TOC entry 3000 (class 0 OID 0)
-- Dependencies: 207
-- Name: seq_sector; Type: SEQUENCE SET; Schema: public; Owner: nanoo
--

SELECT pg_catalog.setval('public.seq_sector', 1050, true);


--
-- TOC entry 3001 (class 0 OID 0)
-- Dependencies: 208
-- Name: seq_site; Type: SEQUENCE SET; Schema: public; Owner: nanoo
--

SELECT pg_catalog.setval('public.seq_site', 150, true);


--
-- TOC entry 3002 (class 0 OID 0)
-- Dependencies: 209
-- Name: seq_topo; Type: SEQUENCE SET; Schema: public; Owner: nanoo
--

SELECT pg_catalog.setval('public.seq_topo', 10000, false);


--
-- TOC entry 3003 (class 0 OID 0)
-- Dependencies: 210
-- Name: seq_way; Type: SEQUENCE SET; Schema: public; Owner: nanoo
--

SELECT pg_catalog.setval('public.seq_way', 2050, true);


---------------------------------------------------------------
---------------------------------------------------------------


--
-- TOC entry 2837 (class 2606 OID 59479)
-- Name: account account_pkey; Type: CONSTRAINT; Schema: public; Owner: nanoo
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (id);


--
-- TOC entry 2841 (class 2606 OID 59484)
-- Name: commentary commentary_pkey; Type: CONSTRAINT; Schema: public; Owner: nanoo
--

ALTER TABLE ONLY public.commentary
    ADD CONSTRAINT commentary_pkey PRIMARY KEY (id);


--
-- TOC entry 2845 (class 2606 OID 59550)
-- Name: sector sector_pkey; Type: CONSTRAINT; Schema: public; Owner: nanoo
--

ALTER TABLE ONLY public.sector
    ADD CONSTRAINT sector_pkey PRIMARY KEY (id);


--
-- TOC entry 2847 (class 2606 OID 59558)
-- Name: site site_pkey; Type: CONSTRAINT; Schema: public; Owner: nanoo
--

ALTER TABLE ONLY public.site
    ADD CONSTRAINT site_pkey PRIMARY KEY (id);


--
-- TOC entry 2849 (class 2606 OID 59566)
-- Name: topo topo_pkey; Type: CONSTRAINT; Schema: public; Owner: nanoo
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT topo_pkey PRIMARY KEY (id);


--
-- TOC entry 2843 (class 2606 OID 59513)
-- Name: topobooking topobooking_pkey; Type: CONSTRAINT; Schema: public; Owner: nanoo
--

ALTER TABLE ONLY public.topobooking
    ADD CONSTRAINT topobooking_pkey PRIMARY KEY (id);


--
-- TOC entry 2839 (class 2606 OID 59523)
-- Name: account uk_c5duyrtdgqnx2uxhpjcx8cdm3; Type: CONSTRAINT; Schema: public; Owner: nanoo
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT uk_c5duyrtdgqnx2uxhpjcx8cdm3 UNIQUE (mail);


--
-- TOC entry 2851 (class 2606 OID 59574)
-- Name: way way_pkey; Type: CONSTRAINT; Schema: public; Owner: nanoo
--

ALTER TABLE ONLY public.way
    ADD CONSTRAINT way_pkey PRIMARY KEY (id);


--
-- TOC entry 2852 (class 2606 OID 59583)
-- Name: sector fkjfgcmlu9h9l8dptrpqmon2lw8; Type: FK CONSTRAINT; Schema: public; Owner: nanoo
--

ALTER TABLE ONLY public.sector
    ADD CONSTRAINT fkjfgcmlu9h9l8dptrpqmon2lw8 FOREIGN KEY (id_site) REFERENCES public.site(id);


--
-- TOC entry 2853 (class 2606 OID 59588)
-- Name: way fksmviq140titf1vjxtmlxg526w; Type: FK CONSTRAINT; Schema: public; Owner: nanoo
--

ALTER TABLE ONLY public.way
    ADD CONSTRAINT fksmviq140titf1vjxtmlxg526w FOREIGN KEY (id_sector) REFERENCES public.sector(id);


-- Completed on 2019-11-12 22:04:23 CET

--
-- PostgreSQL database dump complete
--

