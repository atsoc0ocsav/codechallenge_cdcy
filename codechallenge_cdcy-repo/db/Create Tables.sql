--####Files Base64
-- Sequence: public.todo_id_seq

-- DROP SEQUENCE public.todo_id_seq;

CREATE SEQUENCE public.todo_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 7
  CACHE 1;
ALTER TABLE public.todo_id_seq
  OWNER TO cdcy;
  

-- Table: public.Todo

-- DROP TABLE public.Todo;

CREATE TABLE public.Todo
(
  id integer NOT NULL DEFAULT nextval('todo_id_seq'::regclass),
  title character varying(250) default NULL,
  completed boolean not NULL default FALSE,
  constraint "PK_ID_IMAGES" primary key (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.Todo
  OWNER TO cdcy;
  