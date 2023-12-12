CREATE TABLE accounts (
    id VARCHAR(36) NOT NULL,
    customer_id VARCHAR(36) NOT NULL,
    name VARCHAR(50) NOT NULL,
    type VARCHAR(50) NOT NULL,
    status BOOLEAN NOT NULL,
    amount BIGINT,
    created_date TIMESTAMP NOT NULL,
    updated_date TIMESTAMP
);

CREATE TABLE customers (
    id VARCHAR(36) NOT NULL,
    name VARCHAR(50) NOT NULL,
    status BOOLEAN NOT NULL,
    birth_date TIMESTAMP NOT NULL,
    created_date TIMESTAMP NOT NULL,
    updated_date TIMESTAMP
);

CREATE TABLE products (
    id VARCHAR(36) NOT NULL,
    name VARCHAR(50) NOT NULL,
    created_date TIMESTAMP NOT NULL,
    updated_date TIMESTAMP
);

CREATE TABLE product_price (
    id VARCHAR(36) NOT NULL,
    product_id VARCHAR(36) NOT NULL,
    price BIGINT,
    created_date TIMESTAMP NOT NULL,
    updated_date TIMESTAMP
);

CREATE TABLE wishlist (
    id VARCHAR(36) NOT NULL,
    product_id VARCHAR(36) NOT NULL,
    customer_id VARCHAR(36) NOT NULL,
    created_date TIMESTAMP NOT NULL,
    updated_date TIMESTAMP
);

CREATE TABLE order (
    id VARCHAR(36) NOT NULL,
    product_id VARCHAR(36) NOT NULL,
    customer_id VARCHAR(36) NOT NULL,
    price BIGINT,
    created_date TIMESTAMP NOT NULL,
    updated_date TIMESTAMP
);

CREATE TABLE payment (
    id VARCHAR(36) NOT NULL,
    order_id VARCHAR(36) NOT NULL,
    status VARCHAR(50) NOT NULL,
    price BIGINT,
    created_date TIMESTAMP NOT NULL,
    updated_date TIMESTAMP
);