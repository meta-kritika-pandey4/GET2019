alter table product
drop column category_id;

create table product_category(
product_id varchar(100) references product(product_id),
category_id varchar(100) references category(category_id));

insert into product_category
values('prod001','cat05'),
('prod002', 'cat05'),
('prod003', 'cat06'),
('prod004', 'cat06'),
('prod005', 'cat07'),
('prod006', 'cat07'),
('prod007', 'cat08'),
('prod008', 'cat08'),
('prod008', 'cat09'),
('prod009', 'cat09'),
('prod010', 'cat09'),
('prod011', 'cat10'),
('prod012', 'cat10'),
('prod013', 'cat11'),
('prod014', 'cat11'),
('prod015', 'cat12'),
('prod016', 'cat12'),
('prod013', 'cat13'),
('prod014', 'cat13'),
('prod017', 'cat13'),
('prod018', 'cat13'),
('prod019', 'cat14'),
('prod020', 'cat14'),
('prod021', 'cat15'),
('prod022', 'cat15'),
('prod023', 'cat16'),
('prod024', 'cat16');

-- Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.

select p.product_id, p.product_name, count(pc.category_id) as Count_Categories
from product p 
inner join product_category pc
on p.product_id=pc.product_id
group by p.product_id
having Count_Categories > 1;

-- Display Count of products as per the price range:

select product_price, count(*) count_of_product_id from 
(select 
case 
when product_price between 0 and 100 then '0 - 100' 
when product_price between 101 and 500 then '101 - 500' 
when product_price > 500 then 'Above 500' end as product_price
from product) as count_of_product_id
group by product_price;

-- Display the Categories along with number of products under each category.

select c.category_id, c.category_name, count(pc.product_id) as Count_Products
from category c 
inner join product_category pc
on c.category_id=pc.category_id
group by c.category_id
having Count_Products > 1;