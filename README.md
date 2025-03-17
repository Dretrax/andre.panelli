# E-commerce API

Este projeto é uma API para gerenciamento de pedidos e produtos em um e-commerce.

## Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot (Security, Data, Web, etc.)**
- **MySQL**
- **Elasticsearch**
- **Kafka**

## Como Rodar o Projeto

### 1. Configurar Banco de Dados MySQL
1. Instale o MySQL e crie um banco de dados chamado `ecommerce_db`.
2. Execute o dump SQL:
   ```sh
   mysql -u root -p ecommerce_db < ecommerce_db_dump.sql
   ```

### 2. Configurar Kafka
1. Instale e inicie o Apache Kafka.
2. Crie os tópicos necessários:
   ```sh
   kafka-topics.sh --create --topic order.created --bootstrap-server localhost:9092
   kafka-topics.sh --create --topic order.paid --bootstrap-server localhost:9092
   ```

### 3. Configurar Elasticsearch
1. Instale e inicie o Elasticsearch.
2. Configure o índice `products`:
   ```sh
   curl -X PUT "localhost:9200/products" -H "Content-Type: application/json" -d '{}'
   ```

### 4. Rodar a Aplicação
1. Configure o Kafka e o MySQL no arquivo `application.properties`.
2. Compile e execute o projeto:
   ```sh
   mvn clean install
   java -jar target/ecommerce-api.jar
   ```

### 5. Endpoints Disponíveis
- **Autenticação:** `/auth/login`
- **Produtos:** `/products`
- **Pedidos:** `/orders`
- **Relatórios:** `/reports/top-buyers`, `/reports/avg-ticket`, `/reports/total-revenue`

---
Desenvolvido para o desafio técnico 🚀
