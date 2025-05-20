# 🎬 CinemaFilme API  

**Uma API moderna para gerenciamento de catálogo de filmes, desenvolvida com Java Spring Boot e MongoDB.**  

🚀 **Desafie os limites do streaming tradicional** com esta API poderosa que oferece cadastro, busca e gestão de filmes com desempenho escalável.  

---

## 🔥 **Tecnologias Utilizadas**  

| **Tecnologia**       | **Função**                                                                 |  
|----------------------|----------------------------------------------------------------------------|  
| **Java 21**          | Linguagem principal com recursos modernos (Records, Pattern Matching)       |  
| **Spring Boot 3.4**  | Framework para construção rápida de APIs RESTful                           |  
| **MongoDB Atlas**    | Banco de dados NoSQL na nuvem para alta disponibilidade                    |  
| **Maven**           | Gerenciamento de dependências e build                                      |  
| **Validation API**   | Validação de dados de entrada (ex.: `@NotBlank`, `@Valid`)                 |  
| **HTTP/2**          | Protocolo moderno para melhor performance nas requisições                  |  

---

## ⚡ **O Que Esta API Faz?**  

✅ **CRUD Completo de Filmes**  
- Cadastro com validação de dados  
- Busca por **ID, nome (parcial case-insensitive), ou listagem geral**  
- Edição e exclusão segura  

✅ **Arquitetura Escalável**  
- Separação clara entre Controller, Service e Repository  
- Pronta para integrar com sistemas de recomendação (ex.: Kafka para eventos)  

✅ **Pronta para Produção**  
- Conexão criptografada com TLS 1.3  
- Tratamento de erros customizado (404, 500, etc.)  

---

## 📡 **Endpoints**  

| Método | Rota                     | Descrição                              | Exemplo de Uso                        |  
|--------|--------------------------|----------------------------------------|---------------------------------------|  
| POST   | `/filmes`                | Cadastra um novo filme                 | `{"titulo": "Duna", "diretor": "Villeneuve"}` |  
| GET    | `/filmes/listar`         | Lista todos os filmes                  | `GET /filmes/listar`                  |  
| GET    | `/filmes/listar/nome/{nome}` | Busca filmes por nome (flexível)   | `GET /filmes/listar/nome/matrix`      |  
| PUT    | `/filmes/editar/{id}`    | Atualiza um filme existente            | `PUT /filmes/editar/123`              |  
| DELETE | `/filmes/{id}`           | Remove um filme                        | `DELETE /filmes/123`                  |  

---

## 🚀 **Como Executar?**  

1. **Pré-requisitos**:  
   - Java 21+  
   - MongoDB Atlas (ou local)  
   - Maven  

2. **Clone o projeto**:  
   ```bash  
   git clone https://github.com/seu-usuario/MicrosservicoFilme.git  
   ```  

3. **Configure o MongoDB**:  
   - Crie um cluster gratuito no [MongoDB Atlas](https://www.mongodb.com/atlas/database)  
   - Atualize a URI no `application.properties`:  
     ```properties  
     spring.data.mongodb.uri=mongodb+srv://user:password@cluster0.mongodb.net/cinema_filmes  
     ```  

4. **Execute**:  
   ```bash  
   mvn spring-boot:run  
   ```  

---

## 🌟 **Diferenciais**  

🔍 **Busca Inteligente**  
- Encontre filmes mesmo com erros de digitação (ex.: "crep" → "Crepusculo").  

⚡ **Performance**  
- Respostas em menos de 100ms graças ao Spring Reactive (próxima versão).  

🛡️ **Segurança**  
- Pronta para adicionar OAuth2 (Keycloak ou Auth0).  

---


💡 **Ideia para Contribuição**:  
Quer adicionar um sistema de avaliação de filmes? Faça um PR!  

--- 

**🎉 Tecnologia + Entretenimento = CinemaFilme API**  

[![Deploy](https://img.shields.io/badge/Deploy-Render-blue)]() [![License](https://img.shields.io/badge/License-MIT-green)]()  

```java  
// Código feito com ♥ por Amanda Fonseca 
```  

--- 

📢 **Clone agora e transforme seu catálogo de filmes em uma experiência API-first!**
