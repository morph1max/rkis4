create database washing owner postgres;

CREATE TABLE IF NOT EXISTS washing (
    id int,
    weight int,
    clothingCapacity int,

    manufacturingCompany varchar,
    model varchar,
    ProducingCountry varchar
);

INSERT INTO  washing (id, weight, clothingCapacity, manufacturingCompany, model, ProducingCountry)
VALUES (1, 322, 18, 'Apple', 'Tank-2000', 'Russia'),
       (2, 232, 30, 'Lada', 'Grantwashing', 'USA');
