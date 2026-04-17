# 📚 API de Gerenciamento de Estudantes

## 📌 Descrição

API REST desenvolvida em Java com Spring Boot para gerenciamento de estudantes.
O sistema permite realizar operações de cadastro, listagem, atualização e remoção de alunos, seguindo boas práticas de arquitetura em camadas.

---

## 🚀 Tecnologias utilizadas

* Java
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven

---

## 🧠 Arquitetura

O projeto foi estruturado seguindo o padrão de camadas:

* **Controller** → Responsável pelos endpoints da API
* **Service** → Contém as regras de negócio
* **Repository** → Acesso ao banco de dados
* **Entity** → Representação das tabelas
* **DTO** → Transferência de dados
* **Mapper** → Conversão entre Entity e DTO

---

## ⚙️ Funcionalidades

* ✅ Cadastro de estudantes
* ✅ Listagem de estudantes
* ✅ Busca por ID
* ✅ Atualização de dados
* ✅ Remoção de estudantes

---

## 🔗 Endpoints

### ➕ Criar estudante

`POST /students`

### 📄 Listar estudantes

`GET /students`

### 🔍 Buscar por ID

`GET /students/{id}`

### ✏️ Atualizar estudante

`PUT /students/{id}`

### ❌ Deletar estudante

`DELETE /students/{id}`

---

## 🗄️ Banco de Dados

O projeto utiliza PostgreSQL.

Tabela principal:

* **students**

  * id
  * name
  * course

---

## ▶️ Como rodar o projeto

### Pré-requisitos:

* Java 17+
* PostgreSQL
* Maven

### Passos:

1. Clone o repositório:

```
git clone https://github.com/Lhenrique21/student-management-api
```

2. Configure o banco de dados no `application.properties`

3. Execute o projeto:

```
mvn spring-boot:run
```

4. A API estará disponível em:

```
http://localhost:8080
```

---

## 🧪 Testes

Você pode testar a API utilizando:

* Postman
* Insomnia
---

## 👨‍💻 Autor

Desenvolvido por Luiz Henrique.

* GitHub: https://github.com/Lhenrique21
* LinkedIn: https://www.linkedin.com/in/lhenrique21/

---

## ⭐ Observação

Este projeto foi desenvolvido com foco em aprendizado e prática de desenvolvimento backend utilizando Java e Spring Boot.
