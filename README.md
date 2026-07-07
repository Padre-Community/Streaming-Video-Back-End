> # Aplicação de Streaming Video Max da Padre Community 🚀
---

> ## Descrição do Projeto
---
**O projeto consiste na construção de uma plataforma Web/API para Entretenimento e criação de videos/streams**

**Baseado em plataformas como Vimeo, Wistia, Brightcove e Youtube, o intuito é, o Entretenimento visual com conceito de diversão, informação, educação e o fomento da liberdade cultural e visual**

**Sendo assim, foram criados os serviços:**
* **Página Web para visualização e cadastramento dos usuários**
* **Publicação de videos**
* **Publicação de comentários**
* **Listar usuários cadastrados**
* **Seguir usuários**
* **Encontrar usuário(s) e/ou video(s) por filtragem (por letra/terminação inicial e/ou final) ou seu nome/sobrenome**

> ## Tecnologias Utilizadas
---
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Maven](https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/github%20actions-%232671E5.svg?style=for-the-badge&logo=githubactions&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=white)
![Portainer](https://img.shields.io/badge/Portainer-13BEF9?style=for-the-badge&logo=portainer&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Discord](https://img.shields.io/badge/Discord-%235865F2.svg?style=for-the-badge&logo=discord&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
![Prometheus](https://img.shields.io/badge/Prometheus-E6522C?style=for-the-badge&logo=Prometheus&logoColor=white)
![Grafana](https://img.shields.io/badge/Grafana-F2F4F9?style=for-the-badge&logo=grafana&logoColor=orange&labelColor=F2F4F9)
![UptimeKuma](https://img.shields.io/badge/UptimeKuma-168363?style=for-the-badge&logo=dogecoin&logoColor=white)

**As seguintes ferramentas foram utilizadas na construção do projeto**
- [Java - v21](https://www.oracle.com/br/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)
- [Spring Boot](https://spring.io/)
- [Swagger Docs](https://swagger.io/)

> ## Práticas adotadas
---

- **Página Web**
- **API REST**
- **Banco de Dados Relacional**
- **Arquitetura Modular**
- **Containerização**
- **Tratamento de respostas de erro**
- **Implementação de esteira CI/CD Actions**

> ## Instalação
---
**Tenha instalado em seu sistema operacional:**
> - [JAVA NA VERSÃO 21 OU SUPERIOR](https://www.oracle.com/br/java/technologies/downloads/#java21)
>
> - [MAVEN](https://maven.apache.org/download.cgi)
>
> - [GIT](https://git-scm.com/downloads)

> ## Instrução de Configuração e Instação
---

**Guia de Documentação com Instruções para Configuração do Ambiente de Desenvolvimento**
- [JAVA](docs/JAVA.md)
- [Maven](docs/MAVEN.md)
- [GIT](docs/GIT.md)
- [Docker](docs/DOCKER.md)
- [IntelliJ](docs/INTELLIJ.md)
- [Commandos GIT](docs/COMMANDS_GIT.md)
- [Commandos Maven](docs/COMMANDS_MAVEN.md)

> ## Executor
---

- **Após instalar o Docker, execute o comando abaixo:**
```bash
   docker-compose up -d
```

- **Clonar repositório `GITHUB`**
```bash
   git clone [url do repositório]
```
- **Ir até o diretório/pasta localizando a aplicação**
```bash
   cd [caminho onde realizou o clone]
```
- **Construir o projeto**
````bash
    mvn clean install
````

> ## EXECUTE
---

- **Para acessar a aplicação, via [Web](http://localhost:8080)**
````bash
    http://localhost:8080
````
- **Para acessar a API, via [Swagger-UI](http://localhost:8080/swagger-ui/index.html#/)**
````bash
    http://localhost:8080/swagger-ui/index.html#/
````
> ## EXECUTAR APLICAÇÃO VIA IDE
---

**Clone realizado, inicializar o projeto:**

- **Na raíz do projeto, em um terminal, executar a aplicação**
```bash
   mvn spring-boot:run
```
- **ou use o wrapper run**
```bash
  .\mvnw spring-boot:run
```