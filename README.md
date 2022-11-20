# Microsserviços com Apache Camel

![Repository language count](https://img.shields.io/github/languages/count/didifive/estudo-apachecamel-activemq)
![Repository code size](https://img.shields.io/github/languages/code-size/didifive/estudo-apachecamel-activemq)
[![GitHub last commit](https://img.shields.io/github/last-commit/didifive/estudo-apachecamel-activemq?color=blue)](https://github.com/didifive/estudo-apachecamel-activemq/commits/master)
[![Made by Didi](https://img.shields.io/badge/made%20by-Didi-green)](https://www.linkedin.com/in/luis-carlos-zancanela/)
![Repository license](https://img.shields.io/github/license/didifive/estudo-apachecamel-activemq)

## 🎯 Objetivo

O objetivo deste projeto é criar uma integração de microsserviços com o Framework [Apache Camel] para estudo da tecnologia e dinâmica de comunicação de microsserviços utilizando serviço de mensageria, criando produtores e consumidores para as filas.

## 📋 Projeto

![technology Java](https://img.shields.io/static/v1?color=red&label=Technology&message=Java&style=for-the-badge&logo=data:image/png;base64,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)
![technology Spring](https://img.shields.io/static/v1?color=6DB33F&label=Technology&message=Spring&style=for-the-badge&logo=spring)
![technology Apache Camel](https://img.shields.io/static/v1?color=F69923&label=Technology&message=Apache%20Camel&style=for-the-badge&logo=data:image/png;base64,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)
![technology Apache ActiveMQ](https://img.shields.io/static/v1?color=C12766&label=Technology&message=ActiveMQ&style=for-the-badge&logo=data:image/png;base64,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)
![technology Docker](https://img.shields.io/static/v1?color=blue&label=Technology&message=Docker&style=for-the-badge&logo=docker)

Para este projeto foi imaginado uma situação com um dispositivo que emite a temperatura de um equipamento e a criação de notificação e alerta de temperatura, para isso foram pensados 3 microsserviços, sendo:

- TempSensor: Microsserviço que simula um dispositivo IoT que emite a temperatura de um equipamento monitorado, como, por exemplo, temperatura de um torno de usinagem CNC.
- TempMonitor: Microsserviço que consome a fila com mensagens geradas pelo TempSensor e cria agrupamentos para acompanhamento e alerta para quando a temperatura ultrapassa o limite aceitável, produz mensagens para filas para notificações para outro serviço consumir.
- Notifier: Microsserviço que consume as filas de notificações e fica responsável por realizar o envio de email de acompanhamento e alerta para o responsável do monitoramento.  

## 🖌 Visuais

Diagrama de relação dos microsserviços:  
![Camel Microservices Diagram](docs/camel-microservices-diagram.drawio.png?raw=true "Camel Microservices Diagram")  
Tela do ActiveMQ:  
![ActiveMQ Screen](docs/activemq.png?raw=true "ActiveMQ Screen")  
Tela do MailCatcher com E-mail de Notificação de temperaturas:  
![MailCatcher Notification Screen](docs/mailcatcher-notification.png?raw=true "MailCatcher Notification Screen")  
Tela do MailCatcher com E-mail de Alerta de temperaturas altas:  
![MailCatcher High Temperature Alert Screen](docs/mailcatcher-alert.png?raw=true "MailCatcher High Temperature Alert Screen")  
Logs dos microsserviços executados em containers do docker:  
![Terminal Docker Logs](docs/terminal-docker-logs.png?raw=true "Terminal Docker Logs")  

## 🧱 Configuração

O projeto foi construído com:

- IDE IntelliJ IDEA Community Edition 2022.1.1.
- Os microsserviços foram iniciados com a utilização do [Spring Initializr] e as configurações:
  - Project: Gradle Project
  - Language: Java
  - Spring Boot 2.7.5
  - Packaging: Jar
  - Java 17
- Todos os microsserviços possuem as dependências:
  - camel-spring-boot-starter
  - camel-activemq-starter
  - camel-jackson-starter
- Para o microsserviço Notifier foi utilizado também o Java Mail Sender para envio de email.
- Os recursos abaixo ficam disponíveis através de conteiners do Docker:
  - ActiveMQ: gerenciador de mensagens
  - MailCatcher: cria um servidor de emails local e possui acesso a caixa para checar os emails gerados

## 💾 Instalação

Para executar o projeto é necessário fazer download ou clone deste repositório e:

- Possuir Docker e Docker Compose para iniciar o ActiveMQ, MailCatcher e os microsserviços

  OU

- Possuir Docker e Docker Compose para iniciar o ActiveMQ e MailCatcher e o Java JDK 17 (mínimo) para executar os microsserviços diretamente


## 👨‍💻 Uso

### Executar tudo somente com o Docker

Para iniciar todo o projeto com o Docker, no terminal utilize o comando:

```bash
docker compose up
```

Após isso os containers irão subir e é só acompanhar os logs e acessar as páginas do ActiveMQ e do MailCatcher para verificar as filas e os emails

### Executar os microsserviços diretamente da IDE ou terminal

Primeiramente deve iniciar os conteiners do ActiveMQ e do MailCatcher, no terminal utilize o comando:

```bash
docker compose -f docker-compose-local.yml up
```

Após é só fazer a execução dos microsserviços pela IDE ou terminal, acompanhar os logs e acessar as páginas do ActiveMQ e do MailCatcher para verificar as filas e os emails

### Acessar as filas (ActiveMQ) e e-mails (MailCatcher)

Para acessar o ActiveMQ, no navegador acesse o endereço http://localhost:8161/ e clique no link "Manage ActiveMQ broker". O usuário e senha para acesso são ambos "admin" (sem as aspas).  

Para acessar o MailCatcher, no navegador acesse o endereço http://localhost:1080/

---

📚 Conteúdo [Apache Camel Estudos]  
❤ Feito por [Luis Carlos Zancanela] 🚀  
☎ Dúvida, sugestão ou problema é só entrar em contato.

[Apache Camel]: https://camel.apache.org/
[Spring Initializr]: https://start.spring.io/
[Luis Carlos Zancanela]: https://www.linkedin.com/in/luis-carlos-zancanela/
[Apache Camel Estudos]: https://luiscarlosdidi.notion.site/Apache-Camel-Estudos-e1ff7ebff2c14599932a5addc931a9d9