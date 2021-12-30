create table product
(
    id         bigint       not null
        primary key,
    company_id int          null,
    name       varchar(255) null,
    price      float        null,
    quantity   int          null,
    upc        varchar(255) null
);

INSERT INTO productdb.product (id, company_id, name, price, quantity, upc) VALUES (1, 1, 'mobile-9', 800, 2, 'hjdf');
INSERT INTO productdb.product (id, company_id, name, price, quantity, upc) VALUES (2, 1, 'mobile-1', 700, 6, 'hjdf');
INSERT INTO productdb.product (id, company_id, name, price, quantity, upc) VALUES (3, 1, 'mobile-5', 700, 6, 'hjdf');
INSERT INTO productdb.product (id, company_id, name, price, quantity, upc) VALUES (4, 1, 'mobile-2', 700, 6, 'hjdf');
INSERT INTO productdb.product (id, company_id, name, price, quantity, upc) VALUES (5, 2, 'mobile-5', 700, 6, 'hjdf');
INSERT INTO productdb.product (id, company_id, name, price, quantity, upc) VALUES (6, 2, 'mobile-1', 700, 6, 'hjdf');
INSERT INTO productdb.product (id, company_id, name, price, quantity, upc) VALUES (7, 2, 'mobile-3', 700, 6, 'hjdf');
INSERT INTO productdb.product (id, company_id, name, price, quantity, upc) VALUES (8, 2, 'mobile-8', 700, 6, 'hjdf');
INSERT INTO productdb.product (id, company_id, name, price, quantity, upc) VALUES (9, 2, 'mobile-2', 700, 6, 'hjdf');