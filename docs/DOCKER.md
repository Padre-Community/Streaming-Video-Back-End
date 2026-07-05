<p align="center">
 <img src="https://img.shields.io/static/v1?label=OWNER&message=IVAN SANTOS&color=856a68&labelColor=90876I" alt="@ivan_santos"/>
 <img src="https://img.shields.io/static/v1?label=STATUS&message=DEVELOPMENT&color=00ab4e&labelColor=90876I" alt="Status"/>
</p>

> ## Instalação Docker Windows 11

**Primeiramente, tenha acesso ao terminal `DOS ou Power Shell` com privilégio de Admin**

**Vá `Menu Iniciar -> Pacote Windows Power Shell -> Terminal Power Shell Sistema`**

**Selecione o Terminal com botão direito do mouse, mais, executar como Administrador**

**Ou vá até a Lupa ao lado do menu iniciar, digite: Power Shell e selecione a opção executar como Administrador**

**Terminal aberto, copie e cole os comandos abaixo**

### Passo 1 
```bash
 dism.exe /online /enable-feature /featurename:Microsoft-Windows-Subsystem-Linux /all /norestart
```
**Tecle `ENTER`**

### Passo 2 
```bash
 dism.exe /online /enable-feature /featurename:VirtualMachinePlatform /all /norestart
```
**Tecle `ENTER`**

### Passo 3
```bash
 Reinicie o Computador
```

### Passo 4 (Download the Linux kernel update package):
**Copie e cole a URL no seu Browser de preferência**

> [https://wslstorestorage.blob.core.windows.net/wslblob/wsl_update_x64.msi](https://wslstorestorage.blob.core.windows.net/wslblob/wsl_update_x64.msi)

### Passo 5 (PowerShell Admin)

**Volte ao PowerShell, em modo Administrador, copie e cole o comando abaixo**

```bash
 wsl --set-default-version 2
```
**Tecle `ENTER`**

### Passo 6 (Instale o Docker Desktop - Docker Desktop for Windows - x86_64)
**Instale o Docker Desktop conforme instruções do produto**
> [https://docs.docker.com/docker-for-windows/install/](https://docs.docker.com/docker-for-windows/install/)

