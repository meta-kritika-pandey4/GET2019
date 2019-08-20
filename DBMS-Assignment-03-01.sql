-- applying constraint in product table

alter table Product
modify product_name varchar(100) not null,
modify product_price float not null;

-- applying constraint in user table

alter table user
modify user_name varchar(100) not null,
modify dob date not null,
modify password varchar(100) not null,
add check (gender in( 'male', 'female'));

-- applying constraint in admin table

alter table admin
modify permissions varchar(4) not null;

-- applying constraint in shippingaddress table

alter table shippingaddress
modify city varchar(100) not null,
modify state varchar(100) not null,
modify pincode int not null;

-- applying constraint in category table

alter table category
modify category_name varchar(100) not null;

-- applying constraint in image table

alter table image
modify image_name varchar(100) not null;

-- applying constraint in order_item table

alter table order_item
modify ordered_quantity int not null,
add check (order_status in ( 'shipped', 'cancel', 'return' ));

