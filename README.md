# To-Do API

## Sobre o Projeto
Esta é uma API REST simples para gerenciamento de tarefas (To-Do), desenvolvida em **Java** com **Spring Boot** e utilizando o banco de dados em memória **H2**.  
O objetivo do projeto é praticar conceitos fundamentais de APIs REST, CRUD, arquitetura em camadas e integração com banco de dados.

## Funcionalidades
- Criar uma nova tarefa  
- Listar todas as tarefas  
- Listar apenas tarefas pendentes  
- Atualizar uma tarefa existente  
- Deletar uma tarefa  

## Tecnologias Utilizadas
- Java  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- Banco de dados H2 (em memória)  
- Maven  

## Estrutura do Projeto
- **Controller**: responsável por expor os endpoints da API  
- **Service**: contém a regra de negócio  
- **Repository**: acesso aos dados com Spring Data JPA  
- **DTO**: transferência de dados entre camadas  
- **Model/Entity**: representação da entidade no banco de dados  

## Endpoints da API

### Criar tarefa
`POST /todo/create`

### Listar todas as tarefas
`GET /todo/listar`

### Listar tarefas pendentes
`GET /todo/pendentes`

### Atualizar tarefa
`PUT /todo/update/{id}`

### Deletar tarefa
`DELETE /todo/delete/{id}`

## Banco de Dados
O projeto utiliza o **H2**, um banco de dados em memória, ideal para desenvolvimento e testes.

### Console H2
Após iniciar a aplicação, o console pode ser acessado em:

http://localhost:8080/h2-console


**Configurações comuns:**
- JDBC URL: `jdbc:h2:mem:testdb`  
- Username: `sa`  
- Password: *(vazio)*  

## Como Executar o Projeto
1. Clone o repositório  
2. Abra o projeto em uma IDE (IntelliJ, Eclipse, VS Code)  
3. Execute a classe principal com `@SpringBootApplication`  
4. A API estará disponível em `http://localhost:8080`  

## Objetivo Educacional
Este projeto foi criado com fins educacionais para consolidar conhecimentos em:
- APIs REST  
- Spring Boot  
- JPA e H2  
- Boas práticas de organização de código  

## Melhorias Futuras
- Validação de dados  
- Paginação de resultados  
- Autenticação e autorização  

Projeto desenvolvido para fins de estudo em Java e Spring Boot.
