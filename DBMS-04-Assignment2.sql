-- Create a Stored procedure to retrieve average sales of each product in a month. 
-- Month and year will be input parameter to function.

DELIMITER //
CREATE PROCEDURE find_average_sales( mnth INT, yr INT )
 BEGIN
 SELECT product_id, product_name, SUM( ( T.Average_Monthly_Sales ) ) / sum( T.ordered_quantity ) FROM
 ( SELECT p.product_id,p.product_name,oi.ordered_quantity, ( ( p.product_price * ( 100 - oi.discount ) / 100 ) * oi.ordered_quantity )
 AS Average_Monthly_Sales
 FROM product p
 INNER JOIN stock s
 ON p.product_id = s.product_id
 INNER JOIN order_item oi
 ON s.stock_id = oi.stock_id
 INNER JOIN shopping_order so
 ON so.order_id = oi.order_id
 WHERE EXTRACT( MONTH FROM ( so.order_date ) ) = mnth
 AND EXTRACT( YEAR FROM ( so.order_date ) ) = yr
 GROUP BY p.product_id ) AS T
 GROUP BY product_id;
END
//
DELIMITER ;

CALL find_average_sales( 8 , 2019 );

-- Create a stored procedure to retrieve table having order detail with status 
-- for a given period. Start date and end date will be input parameter. 
-- Put validation on input dates like start date is less than end date.
-- If start date is greater than end date take first date of month as start date.

DELIMITER //
CREATE PROCEDURE orderDetails(start Date, finish Date)
BEGIN
 DECLARE startDate DATE;
    IF (start > finish ) THEN
        SELECT DATE_SUB(finish,INTERVAL DAYOFMONTH(finish)-1 DAY) INTO startDate;
    ELSE
        SELECT start INTO startDate;
    END IF;
 SELECT p.product_id, p.product_name, oi.order_id, oi.order_status, so.order_date
 FROM order_item oi INNER JOIN shopping_order so
 ON oi.order_id = so.order_id
 INNER JOIN stock s ON s.stock_id = oi.stock_id
 INNER JOIN product p ON p.product_id = s.product_id
 WHERE DATE( so.order_date ) BETWEEN startDate AND finish;
END;
//
DELIMITER ;

CALL orderDetails( '2019-08-01', '2019-08-14' );







