-- creating view 

create view Store_View
as
select p.product_id, p.product_name, p.product_price, u.user_name, u.user_id, so.order_date, oi.order_status
from product p
inner join stock s
on p.product_id = s.product_id
inner join order_item oi
on s.stock_id = oi.stock_id
inner join shopping_order so
on oi.order_id = so.order_id
inner join user u
on so.user_id = u.user_id
where datediff( current_timestamp(), so.order_date)<60
order by so.order_date desc;

-- display the Products(Items) which are in ‘shipped’ state.

select distinct product_id, product_name
from store_view
where order_status='shipped';

-- display the top 5 most selling products

select product_id, product_name, count(product_id) as No_of_sale
from store_view
group by product_id
order by no_of_sale desc limit 5;

