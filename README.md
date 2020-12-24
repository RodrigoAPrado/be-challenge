# Password Validator

Resumo das principais atividades do micro-serviço.

Validar uma senha dada de acordo com as especificações descritas abaixo:
 - Nove ou mais caracteres
 - Ao menos 1 digito
 - Ao menos 1 letra minúscula
 - Ao menos 1 letra maiúscula
 - Ao menos 1 caracter especial, sendo eles dentro do conjunto !@#$%^&*()-+
 - Não possuir nenhum caractere repetido dentro do conjunto, seja repetição simples (um após o outro) ou outros tipos de repetição (o mesmo caractere, mas não necessariamente um após o outro)
 - Não possuir espaços em branco

---

### Testes
O projeto conta com testes unitários e de integração.
Para rodar os testes basta executar o comando `./gradlew test`

### Tecnologias utilizadas

 - [Kotlin](https://kotlinlang.org/) -
 Este projeto é escrito integralmente em linguagem Kotlin. Para rodar o projeto é recomendado baixar a versão mais atual da linguagem;
 - [Gradle](https://gradle.org/) -
 Para gerenciamento de dependências;
 - [Spring Boot](https://spring.io/projects/spring-boot) -
 O framework foi escolhido por praticidade e tempo de desenvolvimento, bem como facilidade de injenção de dependência e afins.

---

## Subindo o projeto
Para subir o projeto, após instalação das tecnologias utilizadas, basta utilizar o comando ./gradlew run dentro da pasta root. O projeto subirá em localhost na porta 15005 por padrão.
Utilize a ferramenta que achar mais adequada para fazer testes, recomenda-se Postman (https://www.postman.com/) para uma interface mais amistosa ou curl (https://curl.se/) via terminal.

### Endpoints disponíveis na configuração padrão
- GET http://localhost:15005/password/validate/{value}