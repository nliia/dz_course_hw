CREATE TABLE credentials
(
  id bigserial NOT NULL,
  login character varying(50) NOT NULL,
  password character varying(50) NOT NULL,
  salt character varying(50) NOT NULL,
  first_name character varying(50) NOT NULL,
  last_name character varying(50) NOT NULL,
  CONSTRAINT credentials_pkey PRIMARY KEY (id)
)
WITH (
OIDS=FALSE
);
ALTER TABLE credentials
  OWNER TO postgres;


INSERT INTO credentials (id, login, password, salt) VALUES (1, 'masha', md5(concat('123', 'QxLUF1bgIAdeQX')), 'QxLUF1bgIAdeQX', 'Maria', 'Ivanova');
INSERT INTO credentials (id, login, password, salt) VALUES (2, 'tanya', md5(concat('456', 'QxLUF1bgIAdeQX')), 'QxLUF1bgIAdeQX', 'Tatiana', 'Ivanova');
INSERT INTO credentials (id, login, password, salt) VALUES (3, 'victor', md5(concat('789', 'QxLUF1bgIAdeQX')), 'QxLUF1bgIAdeQX', 'Victor', 'Victorov');


