<p align="center">
 <img src="https://img.shields.io/static/v1?label=OWNER&message=IVAN SANTOS&color=856a68&labelColor=90876I" alt="@ivan_santos"/>
 <img src="https://img.shields.io/static/v1?label=STATUS&message=DEVELOPMENT&color=00ab4e&labelColor=90876I" alt="Status"/>
</p>

> ## INICIALIZAÇÃO DO AMBIENTE DE DESENVOLVIMENTO 🚀
---

**Inicialmente, inicialize o `Docker` e realize o comando abaixo:**
````bash
$  docker-compose up -d
````

**Execute o comando para realizar um `scan` e verificar se há atualizações no repositório remoto**
````bash
$  git fetch
````

**Execute o comando abaixo para atualizar e sincronizar o conteúdo do repositório remoto com o seu local**
````bash
$  git pull origin develop
````

**Logo abaixo, estão os links dos serviços gerados pelo `docker-compose`**
---
---

`pg admin - sgbd para verificação dos dados e gerenciamento das tabelas do postgres`
> $ [http://localhost:15432/login?next=/](http://localhost:15432/login?next=/)

`minio - bucket s3 de armazenamento das imagens`
> $ [http://localhost:9001/login](http://localhost:9001/login)

`sonarqube - verificador de code smells e cobertura de código`
> $ [http://localhost:9003/sessions/new?return_to=%2F](http://localhost:9003/sessions/new?return_to=%2F)

`portainer - docker desktop/gerenciador dos containers em modo web browser`
> $ [http://localhost:9000/#!/auth](http://localhost:9000/#!/auth)

`uptime kuma - gerencioador de estado dos containers em modo web browser`
> $ [http://localhost:3001/dashboard](http://localhost:3001/dashboard)

`cadvisor - gerenciador dispatch e métricas dos recursos e serviços`
> $ [http://localhost:8083/containers/](http://localhost:8083/containers/)

`grafana - gestor métrico gráfico das aplicações e containers`
> $ [http://localhost:3000/login](http://localhost:3000/login)

`prometheus - viabilizador de leitura métrica`
> $ [http://localhost:9090/query](http://localhost:9090/query)

`list prom - lista dos comando de leitura métrica dos recursos da aplicação` 
> $ [http://localhost:8080/actuator/prometheus](http://localhost:8080/actuator/prometheus)

`rabbitmq - gerenciador de estado de mensageria assíncrono`
> $ [http://localhost:15672/](http://localhost:15672/) 
