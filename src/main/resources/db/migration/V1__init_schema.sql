create schema if not exists crossword;

create sequence crossword.word_id_seq;

create table crossword.word (
        id int8 not null default nextval('word_id_seq'),
        first_letter varchar(1),
        question varchar(500),
        total_letters int4,
        word varchar(255),
        primary key (id)
    );


