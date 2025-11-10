Virtual Shop API
API REST para gerenciamento de produtos de uma loja virtual, desenvolvida com Spring Boot 3.5.7 e Java 21.

🎯 Sobre o Projeto
A Virtual Shop API é uma aplicação backend que fornece endpoints para operações CRUD de produtos. O projeto foi desenvolvido como exercicio seguindo as melhores práticas de arquitetura em camadas, utilizando DTOs para transferência de dados e validações robustas.
🚀 Tecnologias Utilizadas

Java 21 - Linguagem de programação
Spring Boot 3.5.7 - Framework principal
Spring Data JPA - Persistência de dados
Spring Validation - Validação de dados
H2 Database - Banco de dados em memória
Maven - Gerenciamento de dependências
Jakarta Validation - Validações de beans

⚙️ Funcionalidades

✅ Listagem paginada de produtos
✅ Busca de produto por ID
✅ Cadastro de novos produtos
✅ Atualização de produtos existentes
✅ Remoção de produtos
✅ Validação de dados de entrada
✅ Tratamento de exceções customizado
✅ Paginação de resultados

📦 Pré-requisitos
Antes de começar, você precisará ter instalado em sua máquina:

Java JDK 21 ou superior
Maven 3.9+ (opcional, o projeto inclui Maven Wrapper)
Git

🔧 Instalação

Clone o repositório:

bashgit clone https://github.com/seu-usuario/virtual-shop.git
cd virtual-shop

O projeto já vem com o Maven Wrapper, então não é necessário instalar o Maven separadamente.

▶️ Executando o Projeto
No Linux/Mac:
bash./mvnw spring-boot:run
No Windows:
bashmvnw.cmd spring-boot:run
A aplicação estará disponível em: http://localhost:8080
📡 Endpoints da API
Produtos
MétodoEndpointDescriçãoGET/productsLista todos os produtos (paginado)GET/products/{id}Busca um produto por IDPOST/productsCria um novo produtoPUT/products/{id}Atualiza um produto existenteDELETE/products/{id}Remove um produto
Parâmetros de Paginação
Para endpoints que retornam listas, você pode usar os seguintes parâmetros:

page - Número da página (padrão: 0)
size - Tamanho da página (padrão: 20)
sort - Ordenação (ex: name,asc ou price,desc)

Exemplo:
GET /products?page=0&size=10&sort=name,asc
💡 Exemplos de Uso
Listar Produtos (paginado)
bashcurl -X GET http://localhost:8080/products?page=0&size=5
Buscar Produto por ID
bashcurl -X GET http://localhost:8080/products/1
Criar Novo Produto
bashcurl -X POST http://localhost:8080/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Notebook Dell",
    "description": "Notebook Dell Inspiron 15",
    "price": 3500.00,
    "stock": 10,
    "category": "Informatica"
  }'
Atualizar Produto
bashcurl -X PUT http://localhost:8080/products/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Notebook Dell Atualizado",
    "description": "Notebook Dell Inspiron 15 - Nova Geração",
    "price": 3800.00,
    "stock": 8,
    "category": "Informatica"
  }'
Deletar Produto
bashcurl -X DELETE http://localhost:8080/products/1

✔️ Validações
O ProductDTO possui as seguintes validações:
CampoValidaçõesnameObrigatório, mínimo 3 caracteres, máximo 80 caracteresdescriptionOpcionalpriceObrigatório, deve ser positivostockObrigatório, não pode ser negativocategoryObrigatório, não pode ser vazio
🚨 Tratamento de Erros
A API retorna respostas padronizadas para erros:
Recurso Não Encontrado (404)
json{
  "timestamp": "2025-11-09T10:30:00Z",
  "status": 404,
  "error": "Recurso não encontrado",
  "path": "/products/999"
}
Erro de Validação (422)
json{
  "timestamp": "2025-11-09T10:30:00Z",
  "status": 422,
  "error": "Dados invalidos",
  "path": "/products",
  "erros": [
    {
      "fieldName": "name",
      "message": "Campo requerido"
    },
    {
      "fieldName": "price",
      "message": "O preço deve ser positivo"
    }
  ]
}
💾 Banco de Dados
O projeto utiliza H2 Database em memória para desenvolvimento e testes. O banco é populado automaticamente com dados de exemplo através do arquivo import.sql.
Console H2
Quando a aplicação está rodando, você pode acessar o console do H2 em:
http://localhost:8080/h2-console
Configurações de conexão:

JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (vazio)

Produtos Pré-cadastrados
O banco vem com 15 produtos de exemplo nas seguintes categorias:

🤝 Contribuindo
Contribuições são sempre bem-vindas! Para contribuir:

Faça um Fork do projeto
Crie uma branch para sua feature (git checkout -b feature/MinhaFeature)
Commit suas mudanças (git commit -m 'Adiciona MinhaFeature')
Push para a branch (git push origin feature/MinhaFeature)
Abra um Pull Request

Para dúvidas ou sugestões, abra uma issue no repositório.
