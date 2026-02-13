# 💊 API – Pharmacy Medication
## Hackathon FIAP Pós Tech – Inovação no SUS (Farmácia Popular)

---

## 📌 Sobre o Projeto

Este projeto foi desenvolvido durante um **Hackathon da FIAP – Pós Tech** com o objetivo de propor melhorias digitais para o **SUS**, especificamente para o programa **Farmácia Popular**.

A solução consiste em uma **API RESTful** que permite consultar medicamentos, verificar disponibilidade em farmácias credenciadas e visualizar estoque por região (estado, cidade e bairro), promovendo mais transparência e eficiência no acesso à informação.

O principal objetivo é **reduzir deslocamentos desnecessários da população**, facilitar o acesso a medicamentos e modernizar digitalmente os serviços oferecidos pelo SUS.

---

## 🛠 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker
- Docker Compose
- OpenAPI / Swagger
- Maven

---

## 🎯 Objetivos da Solução

- Permitir consulta de medicamentos por região
- Listar farmácias credenciadas
- Informar disponibilidade de estoque
- Classificar status de estoque (disponível, baixo ou indisponível)
- Registrar feedback das consultas realizadas
- Fornecer documentação automatizada da API

---

## 🏗 Arquitetura Utilizada

O projeto segue uma **Arquitetura em Camadas (Layered Architecture)**, promovendo separação de responsabilidades, organização e escalabilidade.

### 📐 Estrutura Arquitetural

A aplicação é dividida nas seguintes camadas:

### 1️⃣ Controller Layer
### 2️⃣ Business Layer (Service)
### 3️⃣ Infrastructure Layer

---

### 🔎 Benefícios da Arquitetura

- Separação clara de responsabilidades
- Facilidade de manutenção
- Escalabilidade
- Testabilidade
- Padronização de respostas de erro
- Desacoplamento entre domínio e API

---

## 🧩 Modelagem do Domínio

### Principais Entidades

- `Pharmacy` – Representa farmácias credenciadas
- `MedicationName` – Representa medicamentos
- `IndicationCategory` – Categoria de indicação do medicamento
- `PharmacyMedicineStock` – Representa o estoque por farmácia
- `FeedBack` – Registro de feedback das consultas

---

## 📁 Estrutura de Pastas
```
api-pharmacy-medication/
│
├── docker-compose.yml
├── Dockerfile
├── postgres-init.sql
├── pom.xml
│
└── src/main/java/br/com/fiap_tc5/hackaton/
    ├── business/
    ├── config/
    ├── controller/
    │   └── interfaceSwagger/
    └── infrastructure/
        ├── entity/
        ├── repository/
        ├── dtos/
        └── exception/
```
---

### ✔ Status de Estoque

Classificação baseada na quantidade disponível:

- `CRITICAL`
- `NORMAL`
- `HIGH`

---

### ✔ Tratamento Global de Exceções

A aplicação possui:

- Handler global de exceções
- Padronização de erros via `ErrorResponseDTO`
- Tratamento de `ConstraintViolationException`
- Tratamento de `ResourceNotFoundException`

---

## 🛠️ Como Configurar
### Pré-requisitos
- Java 21 ou superior
- Maven
- MySQL
- Docker

### Clone o repositório:
```bash
   git clone https://github.com/fiap-g4-adjt-schedule-management/api-pharmacy-medication.git
```

### Instale as dependências:
```bash
   ./mvnw clean install
```

## 🧩 Variáveis de ambiente
Renomei o arquivo “.env.example” para ".env" ele possui um exemplo de variaveis a utilizar. 
```
DB_URI=jdbc:postgresql://postgres:5432/db-pharmacy-medication
DB_USER=postgres
DB_PASSWORD=12345
```
---

## 💻 Como rodar o projeto
### Executar com Docker Compose
Navegue até o diretório do projeto
```bash
  cd tech-challenge
```
Execute o docker-compose
```bash
  docker-compose up --build
```
### Aplicação estará disponível em:

📍 http://localhost:8088

ou

Utilize a interface interativa disponibilizada pelo Swagger

📍 http://localhost:8088/swagger-ui.html

## 📄 Documentação da API
Após rodar o projeto, acesse a documentação Swagger:

👉 http://localhost:8088/swagger-ui.html

ou

👉 http://localhost:8088/v3/api-docs

---

### Endpoints Principais
- `GET /pharmacy?state=SP&city=SAO%20PAULO&neighb=BRAS` – Listar farmácias credednciadas por região
- `GET /medication` – Listar os principios ativos atendidos pelo programa
- `GET /medication/1` – Lista medicamentos por princípio ativo ex: Asma, Diabetes, Hipertensão...
- `GET /medication/MED001/pharmacys?state=SP&city=SAO%20PAULO&neighb=BRAS` – Lista farmácias com estoque do medicamento

#### Obs: Os endpoints estão documentados e podem ser testados via Swagger UI ou pelo arquivo collection_request.http;

---

## 🎯 Benefícios da Solução
- Redução de deslocamento desnecessário
- Transparência no estoque
- Melhor experiência ao cidadão
- Digitalização de serviços do SUS
- Base para integração futura com apps mobile

---

## 🚀 Proximas Evoluções Futuras
- Integração com geolocalização
- Autenticação via gov.br
- Painel administrativo
- Métricas de uso
- Cache para alta performance
- Integração com sistemas reais do SUS

---

## 👨‍💻 Equipe
- Projeto desenvolvido para o Hackathon FIAP – Pós Tech
- Tema: Inovação Digital no SUS – Farmácia Popular
- Desenvolvido por Mayara Bomfim, WebBer Chagas, Matheus Braga e Raysse Cutrim
