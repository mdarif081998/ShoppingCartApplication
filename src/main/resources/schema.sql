create table brand (brand_id integer not null, brand_availible_status boolean, brand_name varchar(255), quantity integer, primary key (brand_id));
create table customer (customer_id integer not null, address varchar(255), contact_no bigint, customer_name varchar(255), zip_code integer, primary key (customer_id));
create table order_details (order_id integer not null, order_delivered_date DATE, order_dispatched_date DATE, order_placed_date DATE, order_status varchar(255), payment_source varchar(255), payment_status boolean, customer_customer_id integer, product_product_id integer, primary key (order_id));
create table product (product_id integer not null, price decimal(19,2), product_name varchar(255), brand_brand_id integer, primary key (product_id));
