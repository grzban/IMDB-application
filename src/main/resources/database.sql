create table name_basics(
                            nconst VARCHAR PRIMARY KEY,
                            primaryName VARCHAR,
                            birthYear  VARCHAR,
                            deathYear  VARCHAR,
                            primaryProfession VARCHAR,
                            knownForTitles  VARCHAR[]
);


COPY name_basics (nconst, primaryname, birthyear, deathyear, primaryprofession, knownfortitles)
    FROM '/home/gb/CodeCool/TeliaTask/name.basics.tsv'
    DELIMITER E'\t';

create table actor (
                       id int primary key,
                       name varchar);

create table movie(
                      id int primary key,
                      title varchar,
                      year varchar);

-- tconst	titleType	primaryTitle	originalTitle	isAdult	startYear	endYear runtimeMinutes	genres

create table appearance(
                           movie_id int REFERENCES movie(id),
                           actor_id int REFERENCES actor(id),
                           character_name VARCHAR
);
-- tconst  ordering        nconst  category        job     characters:q