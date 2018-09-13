--####Files Base64
-- User: cdcy_test
--DROP USER cdcy_test;
CREATE USER cdcy_test WITH PASSWORD 'xruiI45V7nhnDqj6zRZc';

-- Database: codechallenge_cdcy
--DROP DATABASE codechallenge_cdcy_test;
CREATE DATABASE codechallenge_cdcy_test
    WITH 
    OWNER = cdcy_test
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

GRANT ALL ON DATABASE codechallenge_cdcy_test TO cdcy_test;

GRANT TEMPORARY, CONNECT ON DATABASE codechallenge_cdcy_test TO PUBLIC;
