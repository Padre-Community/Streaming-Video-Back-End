> # Comandos GIT

### Arquivo de leitura rápida para comandos GIT

```bash
   root@server-name:~# git init
```
**inicia o versionamento no git**

```bash
   root@server-name:~# git clone [caminho_repositorio_remoto]
``` 
**clona o repositório remoto em sua máquina local**

```bash
   root@server-name:~# git status
```
**verifica as mudanças e/ou modificações nos arquivos em sua máquina**

```bash
   root@server-name:~# git add .
```
**adiciona as mudanças ao versionamento/stagging**

```bash
   root@server-name:~# git commit -m "mensagem"
```
**salva as mudanças para realização da mesma ao repositório remoto**

```bash
   root@server-name:~# git commit --amend -m "mensagem correta"
```
**corrige o último commit com a mensagem em caso de texto e/ou mensagem errada**

```bash
   root@server-name:~# git reset HEAD
```
**volta o codigo de um ponto específico**

```bash
   root@server-name:~# git reset --soft HEAD~1
```
**desfaz o commit, mas mantém as mudanças**

```bash
   root@server-name:~# git checkout [nome_arquivo]
```
**descarta mudanças em algum ponto específico**

```bash
   root@server-name:~# git branch
```
**lista as branches existentes/criadas**

```bash
   root@server-name:~# git branch -v
```
**lista as branches local com os últimos comentários/mensagens**

```bash
   root@server-name:~# git checkout branch [branch_name]
```
**muda de branch**

```bash
   root@server-name:~# git switch [branch_name]
```
**muda de branch**

```bash
   root@server-name:~# git switch -c [branch_name]
```
**cria uma nova branch e muda para a branch criada**

```bash
   root@server-name:~# git pull
```
**puxa as atualizações da branch master do repositóro remoto para o local**

```bash
   root@server-name:~# git pull origin [branch_name]
```
**puxa as atualizações de uma branch específica do repositóro remoto para o local**

```bash
   root@server-name:~# git pull -u origin [branch_name]
```
**puxa as atualizações do repositóro remoto de uma branch específica**

```bash
   root@server-name:~# git push
``` 
**enviar as suas alterações/mudanças para o repositório remoto**

```bash
   root@server-name:~# git fetch
``` 
**recebe branches remotas que não estão mapeadas**

```bash
   root@server-name:~# git remote -v
``` 
**mostra os caminhos de commit do repositorio remoto**

```bash
   root@server-name:~# git push -u origin [branch_name]
``` 
**envia as alterações para o repositório remoto (como github/gitlab)**

```bash
   root@server-name:~# git shortlog
``` 
**mostra o histórico das alterações/commits realizados referente a branch que você está**

```bash
   root@server-name:~# git log
``` 
**mostra histórico dos commits como autor do envio, data e mensagem**

```bash
   root@server-name:~# git reflog
```
**em caso de delete por acidente de uma branch, encontra o commit perdido**

```bash
   root@server-name:~# git show [hash_number]
``` 
**mostra histórico das mudanças/alterações conforme a linha do tempo de commits**

```bash
   root@server-name:~# git diff
``` 
**mostra a diferença entre arquivos**

```bash
   root@server-name:~# git merge [branch_name] --no-ff
``` 
**une as modificações entre branches**

```bash
   root@server-name:~# git branch -d [branch_name]
``` 
**deleta a branch local**

```bash
   root@server-name:~# git push --delete origin [branch_name]
``` 
**deleta uma branch no repositório remoto**

```bash
   root@server-name:~# git checkout -b [branch_name][branch_mirror]
``` 
**cria uma nova branch copiando a branch de referência**

```bash
   root@server-name:~# git stash save "message"
```
**Para salvar suas alterações sem realizar commit ou envio ao repositório, espécie de stand by**

```bash
   root@server-name:~# git stash apply
```
**Retorna as modificações para branch desejada**

```bash
   root@server-name:~# git stash show
```
**Lista todos os arquivos modificados no ultimo stash**

```bash
   root@server-name:~# git stash clear
```
**Realiza a remoção de todos os stash’s**

```bash
   root@server-name:~# git stash create <mensagem> e git stash save <mensagem>
```
**Ambos criam uma mensagem/nome para o stash**

```bash
   root@server-name:~# git stash pop
```
**Realiza a remoção em ordem de pilha, aplicando as alterações armazenadas no stash mais recente e remove-o da lista**

```bash
   root@server-name:~# git stash
```
**Armazena as alterações feitas no código e limpa o diretório de trabalho**

```bash
   root@server-name:~# git stash list
``` 
**Exibe a lista de stashes armazenados**

```bash
   root@server-name:~# git stash drop
```
**Remove o stash especificado da lista**

```bash
   root@server-name:~# git stash clear
```
**Remove todos os stashes da lista**

```bash
   root@server-name:~# git stash --include-untracked
```
**para armazenar arquivos não rastreados**

```bash
   root@server-name:~# git stash --keep-index
```
**para armazenar apenas as alterações que foram adicionadas com git add**

```bash
   root@server-name:~# git stash -u
```
**para armazenar arquivos não rastreados e alterações**

```bash
   root@server-name:~# git stash branch novo-branch
```
**para criar um novo branch a partir do stash**