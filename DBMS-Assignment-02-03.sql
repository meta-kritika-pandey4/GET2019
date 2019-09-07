-- Display Recent 50 Orders placed (Id, Order Date, Order Total).

select so.order_id, so.order_date, sum((p.product_price*(100-oi.discount)/100)*oi.ordered_quantity) as Order_Total
from shopping_order so
inner join order_item oi
on so.order_id=oi.order_id
inner join stock s
on s.stock_id=oi.stock_id
inner join product p
on p.product_id=s.product_id
group by oi.order_id
order by so.order_date desc limit 50;

-- Display 10 most expensive Orders.

select so.order_id, so.order_date, sum((p.product_price*(100-oi.discount)/100)*oi.ordered_quantity) as Order_Total
from shopping_order so
inner join order_item oi
on so.order_id=oi.order_id
inner join stock s
on s.stock_id=oi.stock_id
inner join product p
on p.product_id=s.product_id
group by oi.order_id
order by Order_Total desc limit 10;

-- Display all the Orders which are placed more than 10 days old and one 
-- or more items from those orders are still not shipped.

select so.order_id, so.order_date
from shopping_order so, order_item oi
where so.order_id = oi.order_id 
and datediff(current_timestamp(), so.order_date) > 10
and oi.order_status != 'Shipped';

-- Display list of shoppers which haven't ordered anything since last month.

select distinct u.user_id, u.user_name
from user u
inner join shopper s
on u.user_id = s.shopper_id
left outer join shopping_order so
on u.user_id=s.shopper_id
where datediff(current_timestamp(),so.order_date)>30;

-- Display list of shopper along with orders placed by them in last 15 days. 

select distinct u.user_id, u.user_name, so.order_id
from user u
inner join shopper s
on u.user_id = s.shopper_id
inner join shopping_order so
on so.user_id=s.shopper_id
where datediff(current_timestamp(),so.order_date)<15;

-- Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))

select p.product_id, p.product_name, oi.order_status
from product p
inner join stock s
on p.product_id=s.product_id
inner join order_item oi
on oi.stock_id=s.stock_id
where oi.order_status='shipped' and oi.order_id='order002';

-- Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price.

select so.order_id, so.order_date, p.product_id, p.product_name, p.product_price
from shopping_order so
inner join order_item oi
on so.order_id=oi.order_id
inner join stock s
on s.stock_id=oi.stock_id
inner join product p
on p.product_id=s.product_id
where p.product_price between 20 and 50;



