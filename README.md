# Microsserviços com Apache Camel

## 🎯 Objetivo

O objetivo deste projeto é criar uma integração de microsserviços com o Framework [Apache Camel] para estudo da tecnologia e dinâmica de comunicação de microsserviços utilizando serviço de mensageria, criando produtores e consumidores para as filas.

## 📋 Projeto

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

❤ Feito por [Luis Carlos Zancanela] 🚀  
☎ Dúvida, sugestão ou problema é só entrar em contato.

[Apache Camel]: https://camel.apache.org/
[Spring Initializr]: https://start.spring.io/
