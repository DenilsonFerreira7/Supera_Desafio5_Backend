
# API de consulta bancário

O projeto foi construído utilizando a linguagem de programação Java, com o framework Spring Boot, que facilita o desenvolvimento de aplicativos Java para a web. O objetivo principal do projeto é fornecer funcionalidades relacionadas a transferências e saldos bancários.

Através dos controladores implementados, é possível realizar consultas de transferências e saldos por diferentes critérios, como conta, período e operador. O projeto utiliza a arquitetura RESTful para expor endpoints que respondem às requisições HTTP e retornam os dados solicitados.

O objetivo principal é oferecer uma API eficiente e organizada para consulta de informações relacionadas a transferências e saldos bancários, permitindo aos usuários obter dados relevantes de forma rápida e fácil.



## Stack utilizada



| ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)|![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)|||
| --- | --- | --- | --- |

Java é uma linguagem de programação popular e versátil, conhecida por sua portabilidade e escalabilidade. Ela é amplamente utilizada no desenvolvimento de aplicativos empresariais, sistemas web, aplicativos móveis e muito mais.

Spring Boot é um framework para o desenvolvimento de aplicativos Java de forma rápida e fácil. Ele fornece um ambiente de configuração simplificado e uma estrutura robusta para construir aplicativos backend. O Spring Boot é conhecido por sua produtividade, flexibilidade e recursos avançados, como injeção de dependência e suporte a APIs REST. Ele é amplamente utilizado na criação de aplicativos empresariais escaláveis e de alta qualidade.

***
**CODIGO**




![Imagem 1](https://i.imgur.com/jSe3okn.png)


O código foi estruturado seguindo uma arquitetura em camadas, com a presença da camada de serviço, controlador (controller) e repositório (repository). A camada de serviço é responsável por implementar a lógica de negócio e fazer a interação com o repositório para acessar os dados. O controlador é responsável por receber as requisições HTTP, tratar os dados e fazer a chamada aos serviços apropriados. O repositório é responsável por fazer a comunicação com o banco de dados, utilizando o JPA e executando consultas personalizadas com queries SQL.

Além disso, foram implementados testes unitários utilizando o framework Mockito para garantir a funcionalidade correta dos métodos. Esses testes são importantes para verificar se o código está produzindo os resultados esperados e para identificar possíveis erros ou falhas.

***


## Aprendizados



Durante o desenvolvimento desse projeto, um dos desafios enfrentados foi implementar a filtragem de dados por data e por um nome personalizado. Essa necessidade exigiu o entendimento dos requisitos e a busca por soluções adequadas.

Para alcançar esse objetivo, foram utilizadas técnicas de filtragem e a criação de consultas personalizadas no repositório, utilizando querys SQL. Isso permitiu obter os resultados desejados, filtrando os dados com base em critérios específicos, como datas e nomes.

Essa experiência foi uma oportunidade de aprimorar o conhecimento em consultas SQL e manipulação de dados, além de fornecer uma solução eficiente e personalizada para as necessidades do projeto.
## Referência

 - [Springboot Documentação](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
 - [StackOverflow](https://stackoverflow.com/)
 - [JdevTreinamentos]()

