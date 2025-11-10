Virtual Shop API
API REST para gerenciamento de produtos de loja virtual com Spring Boot 3.5.7 e Java 21.
🚀 Tecnologias

Java 21
Spring Boot 3.5.7
Spring Data JPA
H2 Database
Maven

⚡ Como Executar
bash# Clone o repositório
git clone https://github.com/seu-usuario/virtual-shop.git

# Entre na pasta
cd virtual-shop

# Execute (Linux/Mac)
./mvnw spring-boot:run

# Execute (Windows)
mvnw.cmd spring-boot:run
Aplicação disponível em: http://localhost:8080
📡 Endpoints
MétodoEndpointDescriçãoGET/productsLista produtos (paginado)GET/products/{id}Busca produto por IDPOST/productsCria novo produtoPUT/products/{id}Atualiza produtoDELETE/products/{id}Remove produto
📝 Exemplo de Requisição
jsonPOST /products
{
  "name": "Notebook Dell",
  "description": "Notebook Dell Inspiron 15",
  "price": 3500.00,
  "stock": 10,
  "category": "Informatica"
}
💾 Banco de Dados
Console H2: http://localhost:8080/h2-console

URL: jdbc:h2:mem:testdb
User: sa
Password: (vazio)
