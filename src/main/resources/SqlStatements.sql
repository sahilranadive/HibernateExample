CREATE USER 'user1'@'localhost' IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON * . * TO 'user1'@'localhost';

CREATE schema jpa_example;
use jpa_example;

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
CREATE TABLE cd (
    id bigint not null auto_increment,
    title varchar(255),
    primary key (id)
);

CREATE TABLE musician (
    id bigint not null auto_increment,
    cd_id bigint not null,
    first_name varchar(50),
    primary key (id),
    foreign key (cd_id) references cd (id)
);



