create database washing owner postgres;

CREATE TABLE IF NOT EXISTS washing (
    id int,
    weight int,
    clothingCapacity int,

    manufacturingCompany varchar,
    model varchar,
    ProducingCountry varchar
);