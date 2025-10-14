# SINAIS API (Spring Boot 3 / Java 17)

## 👥 Equipe
- **Juliana Villalpando Maita** — RM 99224
- **João Victor Dos Santos Morais** — RM 550453
- **Luana Cabezaolias Miguel** — RM 99320
- **Lucca Vilaça Okubo** — RM 551538
- **Pedro Henrique Pontes Farath** — RM 98608


API para o projeto **SINAIS** — app de contenção de vício em jogos online (cassinos, apostas).

## 🧩 Objetivo
Demonstrar **arquitetura orientada a serviços** com autenticação/autorização **JWT** (stateless), princípios **SOLID**, camadas claras (**controller / service / repository**), documentação **OpenAPI** e **testes**.

## 🚀 Como rodar
```bash
mvn spring-boot:run
# Base URL:
# http://localhost:8080
# Swagger UI:
# http://localhost:8080/swagger-ui/index.html
# H2 Console:
# http://localhost:8080/h2 (JDBC: jdbc:h2:mem:sinais)
```
> Usuário de demonstração: `demo@sinais.app` / senha `demo`

## 🔐 Autenticação
- Registro: `POST /api/auth/register` (email, password, fullName) → retorna **token JWT**.
- Login: `POST /api/auth/login` (email, password) → retorna **token JWT**.
- Envie o token nos demais endpoints via header: `Authorization: Bearer <token>`.

## 📚 Endpoints principais
- **Alerts**
  - `POST /api/alerts` — cria alerta (type: `ALTA_EXPOSICAO`, `TENTATIVA_CASSINO` etc.).
  - `GET /api/alerts/user/{userId}` — lista alertas do usuário.
- **Checkups**
  - `POST /api/checkups` — cria checkup de risco (0..100) e notas.
  - `GET /api/checkups/user/{userId}` — lista checkups do usuário.

## 🏗️ Camadas
- **controller** → expõe endpoints e valida entradas.
- **service** → regras de negócio/uso (encapsuladas, testáveis).
- **repository** → persistência com **Spring Data JPA**.
- **security** → JWT/BCrypt, stateless, filtro.
- **domain** → entidades JPA.

## 🧪 Testes
- `UserServiceTests` (unitário) — garante hash de senha e persistência.
- `AuthIntegrationTest` (esqueleto) — base para testes de integração com MockMvc/RestTemplate.
> Recomendações: adicionar **@WebMvcTest** para controllers e **MockMvc** para testes de integração completos.

## 📝 Documentação automática
- Pacote `config/OpenApiConfig.java` com **springdoc + Swagger UI**.
- Descrições em DTOs e controllers podem ser enriquecidas com anotações do OpenAPI.

## 🔧 Tecnologias
- Spring Boot 3.3 / Web / Security / Data JPA
- H2 Database
- JSON Web Token (**jjwt**)
- BCryptPasswordEncoder
- springdoc-openapi

## ✅ Critérios da disciplina cobertos
- **Estrutura / SOLID**: pacotes independentes, services/DTOs/repos separados.
- **Segurança**: stateless, JWT, BCrypt, filtro customizado.
- **Regras como serviços**: `AlertService`, `CheckupService`, `UserService`.
- **Doc OpenAPI**: Swagger UI pronto.
- **Testes**: unitário + base integração.
- **README**: instruções de execução, testes e tecnologias.

## ⚠️ Observações
- **Troque** `security.jwt.secret` no `application.properties` por um segredo forte em produção.
- Ajuste CORS se for consumir via front-end.
- Entidades e casos de uso podem ser expandidos (bloqueio de sites, metas semanais, notificação, etc.).
