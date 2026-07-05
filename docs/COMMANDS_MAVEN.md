> ## Comandos de execução Maven

**Abaixo estão alguns dos principais comandos do Maven para executar no terminal**

**Pode ser executado no PowerShell, DOS, Git Terminal ou no terminal do IntelliJ IDEA**

`PS: Os Comandos deverão ser executados na raíz do projeto (com visão do pom.xml)`

```bash
   $ mvn clean 
```
**Remove todos os arquivos gerados durante o processo de compilação anterior, como arquivos .class e arquivos .jar.**

```bash
   $ mvn help 
```
**Exibe a ajuda do Maven e lista todos os comandos disponíveis.**

```bash
   $ mvn compile
```
**Compila o código-fonte do projeto.**

```bash
   $ mvn package
```
**Cria o pacote do projeto, como um arquivo .jar, .war ou .ear.**

```bash
   $ mvn install
```
**Instala o pacote no repositório local do Maven para uso em outros projetos locais.**

```bash
   $ mvn test
```
**Executa os testes unitários do projeto.**

```bash
   $ mvn dependency:tree
```
**Exibe a árvore de dependências do projeto, mostrando todas as dependências e subdependências do projeto.**

```shell
   $ mvn dependency-check:check 
```
**Verifica as vulnerabilidades e versões obsoletas das libs principais e transitórias**

```bash
   $ mvn site
```
**Gera a documentação do projeto, incluindo relatórios de cobertura de teste e análise de código.**

```bash
   $ mvn clean install
```
**Executa a limpeza, compilação, empacotamento e instalação do pacote em um único comando.**

**Esses são apenas alguns dos principais comandos do Maven. O Maven tem muitos outros comandos e opções que podem ser úteis para diferentes situações de desenvolvimento.**