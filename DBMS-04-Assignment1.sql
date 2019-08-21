-- Create a function to calculate number of orders in a month. Month and year
-- will be input parameter to function.

DELIMITER //
CREATE function countOrders( mon INT, yr INT )
RETURNS INT DETERMINISTIC
BEGIN
 DECLARE count_of_orders INT;
 SELECT COUNT( order_id ) INTO count_of_orders
 FROM shopping_order
 WHERE EXTRACT( MONTH FROM ( shopping_order.order_date ) ) = mon
 AND EXTRACT( YEAR FROM ( shopping_order.order_date ) ) = yr;
 RETURN count_of_orders;
END
//
DELIMITER ;

SELECT countOrders( 8, 2019 ) AS result;


-- Create a function to return month in a year having maximum orders. Year will be input parameter.

DELIMITER //
CREATE FUNCTION maxOrderMonth ( yr INT )
RETURNS INT DETERMINISTIC
BEGIN
 DECLARE resulted_month INT;
 SELECT MAX( order_count ) INTO resulted_month FROM(
 SELECT COUNT( order_id ) AS Order_count 
 FROM shopping_order so
 WHERE EXTRACT( YEAR FROM (so.order_date ) ) = yr
 GROUP BY EXTRACT( MONTH FROM ( so.order_date ) ) ) AS T;
 RETURN resulted_month;
END
//
DELIMITER ;

SELECT maxOrderMonth( 2019 );

