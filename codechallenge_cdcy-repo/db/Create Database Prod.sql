--####Files Base64
-- User: cdcy
--DROP USER cdcy;
CREATE USER cdcy WITH PASSWORD 'QJUkM5I1P0Vec3W4g1NV';

-- Database: codechallenge_cdcy
--DROP DABATASE codechallenge_cdcy;
CREATE DATABASE codechallenge_cdcy
    WITH 
    OWNER = cdcy
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

GRANT ALL ON DATABASE codechallenge_cdcy TO cdcy;

GRANT TEMPORARY, CONNECT ON DATABASE codechallenge_cdcy TO PUBLIC;
