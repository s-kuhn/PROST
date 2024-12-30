CREATE TABLE test
(
    id  UUID NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_test PRIMARY KEY (id)
);

insert into test (id, name) values ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'test');
