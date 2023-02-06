# Micro service para envio de email
Este projeto tem como objetivo criar um micro serviço para envio de e-mail usando o Spring Framework e o RabbitMQ para registro dos e-mail em uma fila.

# Requisitos
- Java 17 ou superior
- Maven 3.8 ou superior
- docker e docker-compose
- PostgreSQL
- Mailhog
- RabbitMQ


## Rodando a aplicação

Subindo os container do PostgreSQL, Mailhog e RabbitMQ
```sh
    docker compose up -d
```

Instalando as dependências
```sh
 ./mvnw clean install -DskipTests
```

Rodando a aplicação
```sh
 ./mvnw spring-boot:run 
```

## Acessando Mailhog e RabbitMQ

- RabbitMQ: http://localhost:5003/
- Mailhog: http://localhost:5001/