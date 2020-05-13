#CREATE USER 'user1'@'localhost' IDENTIFIED BY 'password';
#GRANT ALL PRIVILEGES ON * . * TO 'user1'@'localhost';

#CREATE schema jpa_example;
#use jpa_example;

## To run the samples in simplestructure, create this schema first
CREATE TABLE book (
    id bigint not null auto_increment,
    title varchar(255),
    description varchar(255),
    unitCost float,
    isbn varchar(255),
    nbOfPage int,
    primary key (id)
);

## To run the samples in complexstructure.mapping, create this schema first
CREATE TABLE cd_m (
    id bigint not null auto_increment,
    title varchar(255),
    primary key (id)
);

CREATE TABLE musician_m (
    id bigint not null auto_increment,
    cd_id bigint not null,
    first_name varchar(50),
    last_name varchar(50),
    primary key (id),
    foreign key (cd_id) references cd_m (id)
);

CREATE TABLE cd_i (
    id bigint not null auto_increment,
    title varchar(255),
    description varchar(255),
    unit_cost float,
    total_duration float,
    genre varchar(255),
    primary key (id)
);

CREATE TABLE musician_i (
    id bigint not null auto_increment,
    cd_id bigint not null,
    first_name varchar(50),
    last_name varchar(50),
    primary key (id),
    foreign key (cd_id) references cd_i (id)
);

CREATE TABLE book_i (
    id bigint not null auto_increment,
    title varchar(255),
    description varchar(255),
    unit_cost float,
    isbn varchar(255),
    nb_of_pages int,
    primary key (id)
);



