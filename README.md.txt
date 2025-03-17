# Criar dump do banco de dados MySQL
dump_sql = """
CREATE DATABASE ecommerce_db;
USE ecommerce_db;

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role ENUM('ADMIN', 'USER') NOT NULL
);

CREATE TABLE products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    category VARCHAR(50) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL
);

CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    total_amount DECIMAL(10,2) NOT NULL,
    status ENUM('PENDENTE', 'PAGO', 'CANCELADO') NOT NULL,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE order_items (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);

-- Inserir usuários de exemplo
INSERT INTO users (username, password, role) VALUES
('admin', 'admin', 'ADMIN'),
('user1', 'user1', 'USER');

-- Inserir produtos de exemplo
INSERT INTO products (name, category, price, stock) VALUES
('Laptop', 'Eletrônicos', 3500.00, 10),
('Smartphone', 'Eletrônicos', 2000.00, 15),
('Câmera', 'Fotografia', 1800.00, 8);

"""

# Salvar dump do banco de dados
dump_file_path = "/mnt/data/ecommerce_db_dump.sql"
with open(dump_file_path, "w") as dump_file:
    dump_file.write(dump_sql)

# Retornar caminho do dump
dump_file_path
