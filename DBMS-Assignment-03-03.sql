-- Display Shopper’s information along with number of orders he/she placed during last 30 days.

select s.shopper_id, count(order_id)
from shopper s
inner join shopping_order so
on s.shopper_id = so.user_id
where datediff (current_timestamp(),so.order_date)<30
group by so.user_id;

-- Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.

select so.user_id ,sum((p.product_price*(100-oi.discount)/100)*oi.ordered_quantity) as Order_Total
from shopping_order so
inner join order_item oi
on so.order_id = oi.order_id
inner join stock s
on s.stock_id = oi.stock_id
inner join product p
on p.product_id = s.product_id
where datediff ( current_timestamp(), so.order_date)<30
group by so.user_id
order by Order_Total desc limit 10;

-- Display top 20 Products which are ordered most in last 60 days along with numbers.

select p.product_id, p.product_name, count(oi.stock_id) as Product_Order_Count
from product p
inner join stock s
on p.product_id = s.product_id
inner join order_item oi
on s.stock_id = oi.stock_id
inner join shopping_order so
on so.order_id = oi.order_id
where datediff(current_timestamp(), so.order_date)<60
group by oi.stock_id
order by Product_Order_Count desc limit 20;

-- Display Monthly sales revenue of the StoreFront for last 
-- 6 months. It should display each month’s sale.

SELECT EXTRACT(MONTH FROM so.order_date) as Month_Name, 
sum((p.product_price*(100-oi.discount)/100)*oi.ordered_quantity) as Monthly_Revenue
FROM product p
INNER JOIN stock s
ON p.product_id = s.product_id
inner join order_item oi
on oi.stock_id = s.stock_id
inner join shopping_order so
on oi.order_id = so.order_id
where period_diff(EXTRACT(year_month FROM current_timestamp()),extract(year_month from so.order_date))<6
group by Month_Name;

-- Mark the products as Inactive which are not ordered in last 90 days.

alter table product
add column status varchar(10) check(status in('active','inactive'));

update product p 
left outer join stock s
on p.product_id = s.product_id
left outer join order_item  oi 
on s.stock_id=oi.stock_id 
left outer join shopping_order as so 
on so.order_id=oi.order_id
set p.status = 'inactive'
where datediff(current_timestamp(), so.order_date) > 90
or so.order_id is null;


-- Given a category search keyword, display all the Products present in this category/categories. 

select p.product_id, p.product_name
from product p
inner join product_category pc
on p.product_id = pc.product_id
inner join category c
on pc.category_id = c.category_id
where c.category_id = 'cat04' or c.parent_id = 'cat04';

-- Display top 10 Items which were cancelled most.

select p.product_id, p.product_name, count(order_status) as Cancelled_Count
from product p
inner join stock s
on p.product_id = s.product_id
inner join order_item oi
on s.stock_id = oi.stock_id
where oi.order_status = 'cancel'
group by oi.stock_id
order by Cancelled_Count desc limit 10;





