-- Sequence: test.todo_id_seq
--DROP SEQUENCE public.todo_id_seq;
CREATE SEQUENCE public.todo_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 7
  CACHE 1;
ALTER TABLE public.todo_id_seq
  OWNER TO cdcy_test;
  

-- Table: public.Todo
--DROP TABLE public.Todo;
CREATE TABLE public.Todo
(
  id integer NOT NULL DEFAULT nextval('todo_id_seq'::regclass),
  title CHARACTER VARYING(250) DEFAULT NULL,
  completed BOOLEAN NOT NULL DEFAULT FALSE,
  CONSTRAINT "PK_ID_IMAGES" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.Todo
  OWNER TO cdcy_test;