###Local IMDB application

#Database

- Database engine


    postgres

-  Databease schema
There are three independent tables for actors, movies and actor's roles
in movies. Tables are generated during starting tomcat server.

```sql
CREATE TABLE public.actors (
  id bigint NOT NULL,
  name character varying(255),
  CONSTRAINT actors_pkey PRIMARY KEY (id)
);
```
```sql
CREATE TABLE public.movies (
  id bigint NOT NULL,
  title text,
  year character varying(255),
  CONSTRAINT movies_pkey PRIMARY KEY (id)
);
```
```sql
CREATE TABLE public.roles (
  id bigint NOT NULL DEFAULT nextval('roles_id_seq'::regclass),
  actor_id bigint,
  "character" text,
  movie_id bigint,
  CONSTRAINT roles_pkey PRIMARY KEY (id)
);
```
##download

` wget https://datasets.imdbws.com/title.principals.tsv.gz`

  `wget https://datasets.imdbws.com/name.basics.tsv.gz`

   `wget https://datasets.imdbws.com/title.basics.tsv.gz`
##unarchive

`gzip -d title.principals.tsv.gz`

`gzip -d title.basics.tsv.gz`

`gzip -d name.basics.tsv.gz`

## preparing data for:
- actors:

`cat name.basics.tsv | awk 'BEGIN{FS="\t"};{print $1 "\t" $2}' | sed -e 's/^nm//' > actors.tsv`

- movies

`cat title.basics.tsv | awk 'BEGIN{FS="\t"};{print $1 "\t" $3 "\t" $6}' | sed -e 's/^tt//' > movies.tsv`

- roles

`cat title.principals.tsv | awk 'BEGIN{FS="\t"};{print $1 "\t" $3 "\t" $6}' | sed -e 's/^tt//' -e 's/\tnm/\t/' -e 's/\[//' -e 's/\]//' | grep -v '\\N$' > appearance.tsv
`
##inserting data to database

- actors

`sudo -u postgres psql -d imdb -c "COPY actor FROM '$HOME/project/actors.tsv' DELIMITER E'\t';"`

- movies

`sudo -u postgres psql -d imdb -c "COPY movie FROM '$HOME/project/movies.tsv' DELIMITER E'\t'"`;

- roles

`sudo -u postgres psql -d imdb -c "COPY roles(movie_id, actor_id, character) FROM '$HOME/project/appearance.tsv' DELIMITER E'\t';"`

##Available webservices
http://localhost:8080/v1/actors?page=0&page_size=5
http://localhost:8080/v1/actors/1
http://localhost:8080/v1/actors/1/appearances
http://localhost:8080/v1/movies?page=0&page_size=5
http://localhost:8080/v1/movies/1