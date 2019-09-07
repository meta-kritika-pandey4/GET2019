-- creating table zipcode_map

create table zipcode_map(
zipcode int,
city varchar(50),
state varchar(50));

-- inserting values in the zipcode_map table

insert into zipcode_map
values(282001,'Agra','Uttar Pradesh'),
(302017,'Jaipur','Rajasthan'),
(302034,'Ajmer','Rajasthan'),
(609844,'Srinagar','Jammu & Kashmir');

-- Resultset containing Zip Code, City Names and States ordered by State Name and City Name.

select zipcode,city,state
from zipcode_map
order by state asc, city asc;

