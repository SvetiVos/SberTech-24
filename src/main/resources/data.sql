create schema if not exists jdbc_sch;

create table if not exists jdbc_sch.products
(
    id_product    serial primary key,
    name_product  varchar(255) not null,
    price         numeric      not null,
    quantity      integer      not null
);

create table if not exists jdbc_sch.carts
(
    id_cart      serial primary key,
    promoCode    varchar(255)
);

create table if not exists jdbc_sch.clients
(
    id_client    serial primary key,
    name_client  varchar(255) not null,
    login        varchar(255) not null,
    password     varchar(255) not null,
    email        varchar(255),
    cart_id      integer not null,
    constraint client_cart_id_fk references jdbc_sch.carts
);

create table if not exists jdbc_sch.products_carts
(
    id_products_cart  serial primary key,
    id_product        integer not null,
    constraint product_client_products_id_fk references jdbc_sch.products,
    id_cart           integer not null,
    constraint product_client_cart_id_fk references jdbc_sch.carts,
    quantity          integer not null
);