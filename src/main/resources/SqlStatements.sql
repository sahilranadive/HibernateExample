CREATE USER 'user1'@'localhost' IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON * . * TO 'user1'@'localhost';

CREATE schema jpa_example;
use jpa_example;

CREATE TABLE book (
    id bigint not null auto_increment,
    title varchar(255),
    description varchar(255),
    unitCost float,
    isbn varchar(255),
    nbOfPage int,
    primary key (id)
);

