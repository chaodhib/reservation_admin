--
-- Source code generated by Celerio, a Jaxio product.
-- Documentation: http://www.jaxio.com/documentation/celerio/
-- Follow us on twitter: @jaxiosoft
-- Need commercial support ? Contact us: info@jaxio.com
-- Template pack-backend-jpa:src/main/sql/h2/01-create.p.vm.sql
-- Template is part of Open Source Project: https://github.com/jaxio/pack-backend-jpa
--

DROP ALL objects;


-- =================================
-- TABLE artiste_type 
-- =================================

CREATE TABLE artiste_type (
	id INTEGER(10) not null,
	artist_id INTEGER(10) not null,
	type_id INTEGER(10) not null);

CREATE UNIQUE INDEX IF NOT EXISTS PRIMARY ON artiste_type (id);
ALTER TABLE artiste_type ALTER COLUMN id IDENTITY;


-- =================================
-- TABLE artiste_type_shows 
-- =================================

CREATE TABLE artiste_type_shows (
	id INTEGER(10) not null,
	cast_member_id INTEGER(10),
	shows_id INTEGER(10));

CREATE UNIQUE INDEX IF NOT EXISTS PRIMARY ON artiste_type_shows (id);
ALTER TABLE artiste_type_shows ALTER COLUMN id IDENTITY;


-- =================================
-- TABLE artists 
-- =================================

CREATE TABLE artists (
	id INTEGER(10) not null,
	firstname VARCHAR(60) not null,
	lastname VARCHAR(60) not null);

CREATE UNIQUE INDEX IF NOT EXISTS PRIMARY ON artists (id);
ALTER TABLE artists ALTER COLUMN id IDENTITY;


-- =================================
-- TABLE localities 
-- =================================

CREATE TABLE localities (
	id INTEGER(10) not null,
	postal_code VARCHAR(6) not null,
	locality VARCHAR(60) not null);

CREATE UNIQUE INDEX IF NOT EXISTS locality ON localities (locality);
CREATE UNIQUE INDEX IF NOT EXISTS postal_code ON localities (postal_code);
CREATE UNIQUE INDEX IF NOT EXISTS PRIMARY ON localities (id);
ALTER TABLE localities ALTER COLUMN id IDENTITY;


-- =================================
-- TABLE locations 
-- =================================

CREATE TABLE locations (
	id INTEGER(10) not null,
	slug VARCHAR(60) not null,
	designation VARCHAR(60) not null,
	address VARCHAR(255) not null,
	locality_id INTEGER(10) not null,
	website VARCHAR(255) not null,
	phone VARCHAR(30) not null);

CREATE UNIQUE INDEX IF NOT EXISTS PRIMARY ON locations (id);
CREATE UNIQUE INDEX IF NOT EXISTS slug ON locations (slug);
ALTER TABLE locations ALTER COLUMN id IDENTITY;


-- =================================
-- TABLE representation_user 
-- =================================

CREATE TABLE representation_user (
	id INTEGER(10) not null,
	representation_id INTEGER(10) not null,
	user_id INTEGER(10) not null,
	places INTEGER(10) not null);

CREATE UNIQUE INDEX IF NOT EXISTS PRIMARY ON representation_user (id);
ALTER TABLE representation_user ALTER COLUMN id IDENTITY;


-- =================================
-- TABLE representations 
-- =================================

CREATE TABLE representations (
	id INTEGER(10) not null,
	show_id INTEGER(10) not null,
	when TIMESTAMP not null,
	location_id INTEGER(10));

CREATE UNIQUE INDEX IF NOT EXISTS PRIMARY ON representations (id);
ALTER TABLE representations ALTER COLUMN id IDENTITY;


-- =================================
-- TABLE roles 
-- =================================

CREATE TABLE roles (
	id INTEGER(10) not null,
	role VARCHAR(30) not null);

CREATE UNIQUE INDEX IF NOT EXISTS PRIMARY ON roles (id);
ALTER TABLE roles ALTER COLUMN id IDENTITY;


-- =================================
-- TABLE shows 
-- =================================

CREATE TABLE shows (
	id INTEGER(10) not null,
	slug VARCHAR(60) not null,
	title VARCHAR(255) not null,
	poster_url VARCHAR(255) not null,
	location_id INTEGER(10) not null,
	bookable BIT(1) not null,
	price DECIMAL(10,2) not null);

CREATE UNIQUE INDEX IF NOT EXISTS PRIMARY ON shows (id);
CREATE UNIQUE INDEX IF NOT EXISTS slug ON shows (slug);
ALTER TABLE shows ALTER COLUMN id IDENTITY;


-- =================================
-- TABLE types 
-- =================================

CREATE TABLE types (
	id INTEGER(10) not null,
	type VARCHAR(60) not null);

CREATE UNIQUE INDEX IF NOT EXISTS PRIMARY ON types (id);
ALTER TABLE types ALTER COLUMN id IDENTITY;


-- =================================
-- TABLE users 
-- =================================

CREATE TABLE users (
	id INTEGER(10) not null,
	login VARCHAR(30) not null,
	password VARCHAR(255) not null,
	role_id INTEGER(10) not null,
	firstname VARCHAR(60) not null,
	lastname VARCHAR(60) not null,
	email VARCHAR(100) not null,
	langue VARCHAR(2) not null);

CREATE UNIQUE INDEX IF NOT EXISTS PRIMARY ON users (id);
ALTER TABLE users ALTER COLUMN id IDENTITY;

ALTER TABLE artiste_type ADD CONSTRAINT ARTISTE_TYPE_IBFK_1 FOREIGN KEY (artist_id) REFERENCES artists (id);
ALTER TABLE artiste_type ADD CONSTRAINT ARTISTE_TYPE_IBFK_2 FOREIGN KEY (type_id) REFERENCES types (id);
ALTER TABLE artiste_type_shows ADD CONSTRAINT ARTISTE_TYPE_SHOWS_IBFK_1 FOREIGN KEY (shows_id) REFERENCES shows (id);
ALTER TABLE artiste_type_shows ADD CONSTRAINT ARTISTE_TYPE_SHOWS_IBFK_2 FOREIGN KEY (cast_member_id) REFERENCES artiste_type (id);
ALTER TABLE locations ADD CONSTRAINT LOCATIONS_IBFK_1 FOREIGN KEY (locality_id) REFERENCES localities (id);
ALTER TABLE representation_user ADD CONSTRAINT REPRESENTATION_USER_IBFK_2 FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE representation_user ADD CONSTRAINT REPRESENTATION_USER_IBFK_1 FOREIGN KEY (representation_id) REFERENCES representations (id);
ALTER TABLE representations ADD CONSTRAINT REPRESENTATIONS_IBFK_1 FOREIGN KEY (show_id) REFERENCES shows (id);
ALTER TABLE representations ADD CONSTRAINT REPRESENTATIONS_IBFK_2 FOREIGN KEY (location_id) REFERENCES locations (id);
ALTER TABLE shows ADD CONSTRAINT SHOWS_IBFK_1 FOREIGN KEY (location_id) REFERENCES locations (id);
ALTER TABLE users ADD CONSTRAINT USERS_IBFK_1 FOREIGN KEY (role_id) REFERENCES roles (id);