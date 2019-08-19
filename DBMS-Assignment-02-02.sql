-- insertion into table category

insert into category(category_id,category_name)
values('cat01','grocery'),
('cat02', 'fashion'),
( 'cat03', 'electronics'),
( 'cat04', 'books'),
( 'cat 17', 'pharmacy');
insert into category
values( 'cat05', 'pantry', 'cat01'),
( 'cat06', 'snacks and beverages', 'cat01'),
( 'cat07', 'household supplies', 'cat01'),
( 'cat08', 'men', 'cat02'),
( 'cat09', 'women', 'cat02'),
( 'cat10', 'kids', 'cat02'),
( 'cat11', 'mobile', 'cat03'),
( 'cat12', 'kitchen appliances', 'cat03'),
( 'cat13', 'entertainment appliances', 'cat03'),
( 'cat14', 'novels', 'cat04'),
( 'cat15', 'general awareness', 'cat04'),
( 'cat16', 'encyclopedias', 'cat04');

-- insertion into table product

insert into product
values('prod001','maggi','for late nights, lazy weekend afternoons or impromptu get togethers',20.50,'cat05'),
('prod002','aashirvaad aata',' weight-10kg 100% pure whole wheat aata prepared using the choicest grains ',3090.00,'cat05'),
('prod003','nescafe coffee',' pure natural coffee beans, richer aroma',140.00,'cat06'),
('prod004','kurkure',' tedha medha snacks for funky mood' ,20.00,'cat06'),
('prod005','surf excel','daag ache hain make your clothes new in every wash',340,'cat07'),
('prod006','colgate','har ma ka bharosa whitened teeth',120,'cat07'),
('prod007','Arrow Shirt','pure cotton very comfortable good looking shirt',2000,'cat08'),
('prod008','Pantaloon jeans','comfortable stretchable and rugged jeans',1500,'cat08'),
('prod009','Zara dress','full length floral crescent blue chiffon',4000,'cat09'),
('prod010','Levis purse','leather scratch resistant black colour ',2500,'cat09'),
('prod011','mamy poko pants','dry soft and long lasting',283.00,'cat10'),
('prod012','cookie shorts','warm and soft. cuddles your baby like a mother',1000,'cat10'),
('prod013','One plus 7 pro','fastest smartphone of the time',40000,'cat11'),
('prod014','Redmi Note 5','brilliant smartphone',15000,'cat11'),
('prod015','Prestige induction heater ','fast and good cooking experience',7000,'cat12'),
('prod016','juicer','noiseless and efficient makes your life simple and healthy',3000,'cat12'),
('prod017','home theater','why to go outside when entertainment is inside',32000,'cat13'),
('prod018','alexa','your digital helper',6000,'cat13'),
('prod019','harry potter collection','let yourself drown in the world of JK Rowling',4000,'cat14'),
('prod020','pride and prejudice','a romantic experience of  historical era',300,'cat14'),
('prod021','History NCERT 7th','CBSE full course',140,'cat15'),
('prod022','Science','CBSE full course',120,'cat15'),
('prod023','Picturepedia','Explore the wonders of the world',1201,'cat16'),
('prod024','Tell Me Why','Solves every query of confused kids',500,'cat16');

-- insertion into table user

insert into user
values('kritika.pandey@metacube.com','Kritika Pandey', 'kritika123',DATE '1998-03-07','female'),
('vertika.goyal@metacube.com','Vertika Goyal', 'vertika123',DATE '1996-11-02','female'),
('hitesh.khatri@metacube.com','Hitesh Khatri', 'hitesh123',DATE '1992-01-01','male'),
('priyamvada.sharma@metacube.com','Priyamvada Sharma', 'priyamvada123',DATE '1992-01-01','female'),
('khushi.agrawal@metacube.com','Khushi Agrawal', 'khushi1234',DATE '1996-11-02','female');

-- insertion into table admin

insert into admin
values('hitesh.khatri@metacube.com','rwx'),
('priyamvada.sharma@metacube.com','rx');

-- insertion into table shopper

insert into shopper
values('kritika.pandey@metacube.com',9694595111),
('vertika.goyal@metacube.com',8126227355),
('khushi.agrawal@metacube.com',8126224455);

-- insertion into table shippingaddress

insert into shippingaddress
values('kritika.pandey@metacube.com',26,132,'purusharth nagar','jaipur','rajasthan', 302017),
('kritika.pandey@metacube.com',32,420,'ashok nagar','noida','uttar pradesh', 902017),
('vertika.goyal@metacube.com',71,29,'vibhav nagar','agra','uttar pradesh', 282001);

-- insertion into table shopping_order
insert into shopping_order
values('order001', '2019-08-14 15:02:34','kritika.pandey@metacube.com'),
('order002', '2019-08-14 18:03:55','kritika.pandey@metacube.com'),
('order003','2019-08-14 18:04:54','kritika.pandey@metacube.com'),
('order004', '2019-08-14 18:05:57','vertika.goyal@metacube.com'),
('order005', '2019-08-15 12:04:43','vertika.goyal@metacube.com');

-- insertion into table stock

insert into stock
values ('stk001', 'prod001', 4),
 ('stk002', 'prod002', 5),
 ('stk003', 'prod003', 9),
 ('stk004', 'prod004', 7),
 ('stk005', 'prod005', 2),
 ('stk006', 'prod006', 10),
 ('stk007', 'prod007', 8),
 ('stk008', 'prod008', 4),
 ('stk009', 'prod009', 9),
 ('stk010', 'prod010', 6),
 ('stk011', 'prod011', 3),
 ('stk012', 'prod012', 9),
 ('stk013', 'prod013', 6),
 ('stk014', 'prod014', 5),
 ('stk015', 'prod015', 8),
 ('stk016', 'prod016', 3),
 ('stk017', 'prod017', 5),
 ('stk018', 'prod018', 9),
 ('stk019', 'prod019', 2),
 ('stk020', 'prod020', 1),
 ('stk021', 'prod021', 6),
 ('stk022', 'prod022', 0),
 ('stk023', 'prod023', 5),
 ('stk024', 'prod024', 7);
 
-- insertion into table image

insert into image
values('img1', 'maggi_img1','C:\Users\Vertika\Desktop\PRODUCT IMAGES\maggi_img1', 'prod001'),
('img2', 'maggi_img2','C:\Users\Vertika\Desktop\PRODUCT IMAGES\maggi_img2', 'prod001'),
('img3', 'ashirwad_atta_img1','C:\Users\Vertika\Desktop\PRODUCT IMAGES\aashirvaad_atta_img1', 'prod002'),
('img4', 'nescafe_coffee_img1','C:\Users\Vertika\Desktop\PRODUCT IMAGES\nescafe_coffee_img1','prod003'),
('img5', 'nescafe_coffee_img2','C:\Users\Vertika\Desktop\PRODUCT IMAGES\nescafe_coffee_img2', 'prod003'),
('img6', 'kurkure_img1','C:\Users\Vertika\Desktop\PRODUCT IMAGES\kurkure_img1','prod004'),
('img7', 'kurkure_img2','C:\Users\Vertika\Desktop\PRODUCT IMAGES\kurkure_img2','prod004'),
('img8', 'surf_excel_img1','C:\Users\Vertika\Desktop\PRODUCT IMAGES\surf_excel_img1', 'prod005'),
('img9', 'surf_excel_img2','C:\Users\Vertika\Desktop\PRODUCT IMAGES\surf_excel_img2', 'prod005'),
('img10','colgate_img1','C:\Users\Vertika\Desktop\PRODUCT IMAGES\colgate_img1' ,'prod006'),
('img11','arrow_shirt_img1','C:\Users\Vertika\Desktop\PRODUCT IMAGES\arrow_shirt_img1','prod007'),
('img12','arrow_shirt_img2','C:\Users\Vertika\Desktop\PRODUCT IMAGES\arrow_shirt_img2','prod007'),
('img13','jeans_img1','C:\Users\Vertika\Desktop\PRODUCT IMAGES\jeans_img1', 'prod008'),
('img14','jeans_img2','C:\Users\Vertika\Desktop\PRODUCT IMAGES\jeans_img2', 'prod008'),
('img15','zara_dress_img1','C:\Users\Vertika\Desktop\PRODUCT IMAGES\zara_dress_img1','prod009'),
('img16', 'levis_purse_img1','C:\Users\Vertika\Desktop\PRODUCT IMAGES\levis_purse_img1','prod010'),
('img17', 'levis_purse_img2','C:\Users\Vertika\Desktop\PRODUCT IMAGES\levis_purse_img2','prod010'),
('img18', 'mamy_poko_pants_img1','C:\Users\Vertika\Desktop\PRODUCT IMAGES\mamy_poko_pants_img1','prod011'),
('img19', 'mamy_poko_pants_img2','C:\Users\Vertika\Desktop\PRODUCT IMAGES\mamy_poko_pants_img2','prod011'),
('img20', 'mamy_poko_pants_img3','C:\Users\Vertika\Desktop\PRODUCT IMAGES\mamy_poko_pants_img3','prod011'),
('img21', 'kids_shorts_img1','C:\Users\Vertika\Desktop\PRODUCT IMAGES\kids_shorts_img1', 'prod012'),
('img22', 'kids_shorts_img2','C:\Users\Vertika\Desktop\PRODUCT IMAGES\kids_shorts_img1','prod012'),
('img23', 'one_plus_7pro_img1','C:\Users\Vertika\Desktop\PRODUCT IMAGES\one_plus_7pro_img1','prod013'),
('img24', 'one_plus_7pro_img2','C:\Users\Vertika\Desktop\PRODUCT IMAGES\one_plus_7pro_img2','prod013'),
('img25', 'one_plus_7pro_img3','C:\Users\Vertika\Desktop\PRODUCT IMAGES\one_plus_7pro_img3', 'prod013'),
('img26', 'one_plus_7pro_img4','C:\Users\Vertika\Desktop\PRODUCT IMAGES\one_plus_7pro_img4', 'prod013'),
('img27', 'redmi_note5_img1','C:\Users\Vertika\Desktop\PRODUCT IMAGES\redmi_note5_img1', 'prod014'),
('img28', 'redmi_note5_img2','C:\Users\Vertika\Desktop\PRODUCT IMAGES\redmi_note5_img2', 'prod014'),
('img29', 'prestige_induction_img1','C:\Users\Vertika\Desktop\PRODUCT IMAGES\prestige_induction_img1', 'prod015'),
('img30', 'juicer_img1','C:\Users\Vertika\Desktop\PRODUCT IMAGES\juicer_img1', 'prod016'),
('img31', 'juicer_img2','C:\Users\Vertika\Desktop\PRODUCT IMAGES\juicer_img2', 'prod016'),
('img32', 'juicer_img3','C:\Users\Vertika\Desktop\PRODUCT IMAGES\juicer_img3', 'prod016'),
('img33', 'alexa_img1','C:\Users\Vertika\Desktop\PRODUCT IMAGES\alexa_img1', 'prod018'),
('img34', 'alexa_img2','C:\Users\Vertika\Desktop\PRODUCT IMAGES\alexa_img2', 'prod018'),
('img35', 'harry_potter_collection_img1','C:\Users\Vertika\Desktop\PRODUCT IMAGES\harry_potter_collection_img1', 'prod019'),
('img36', 'harry_potter_collection_img2','C:\Users\Vertika\Desktop\PRODUCT IMAGES\harry_potter_collection_img2', 'prod019'),
('img37', 'pride_and_prejudice_img1','C:\Users\Vertika\Desktop\PRODUCT IMAGES\pride_and_prejudice_img1', 'prod020'),
('img38', 'ncert-img1','C:\Users\Vertika\Desktop\PRODUCT IMAGES\ncert-img1', 'prod021'),
('img39', 'ncert_science_img1','C:\Users\Vertika\Desktop\PRODUCT IMAGES\ncert_science_img1', 'prod022'),
('img40', 'picturepedia_img1','C:\Users\Vertika\Desktop\PRODUCT IMAGES\picturepedia_img1', 'prod023');

-- insertion into table order_item

insert into order_item
values('stk009','order001',2,5,'shipped'),
('stk008','order001',1,8,'shipped'),
('stk007','order001',1,6,'shipped'),
('stk010','order001',1,10,'shipped'),
('stk012','order001',1,0,'shipped'),
('stk001','order002',3,5,'cancel'),
('stk002','order002',2,5,'shipped'),
('stk003','order002',1,10,'shipped'),
('stk004','order002',1,20,'return'),
('stk016','order002',1,5,'shipped'),
('stk014','order003',1,30,'shipped'),
('stk018','order004',1,70,'return'),
('stk006','order004',1,5,'shipped'),
('stk024','order004',1,10,'cancel'),
('stk017','order005',1,5,'shipped'),
('stk019','order005',1,25,'return');

-- Display Id, Title, Category Title, Price of the products which are Active acc to the last insertion

select p.product_id, p.product_name, c.category_name, p.product_price
from product p
inner join category c 
on p.category_id = c.category_id
inner join stock s
on p.product_id = s.product_id
inner join order_item ot
on s.stock_id = ot.stock_id
inner join shopping_order so
on so.order_id = ot.order_id
order by so.order_date desc;

-- Display the list of products which don't have any images.

select product_id,product_name
from product p
where product_id not in ( select product_id from image);

-- Display all Id, Title and Parent Category Title for all the Categories listed,
-- sorted by Parent Category Title and then Category Title. (If Category is 
-- top category then Parent Category Title column should display “Top Category” as value.)

select cat1.category_id, cat1.category_name as 'Category Title', ifnull(cat2.category_name,'Top Category') as 'Parent Category Name'
from category cat1
left outer join category cat2
on cat1.parent_id = cat2.category_id
order by cat2.category_name , cat1.category_name;

-- Display Id, Title, Parent Category Title of all the leaf Categories
-- (categories which are not parent of any other category)

select category_id, category_name
from category 
where category_id not in
(select parent_id from category);


-- Display Product Title, Price & Description which falls into particular category Title 
-- (i.e. “Mobile”)

select p.product_name, p.product_price, p.product_description
from product p
inner join category c
on p.category_id=c.category_id and c.category_name='mobile';


-- Display the list of Products whose Quantity on hand (Inventory) is under 50.

select p.product_id, p.product_name 
from product p
inner join stock s
on p.product_id=s.product_id and s.available_quantity<50;




