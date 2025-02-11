# Criptografia App

## Descrição
Criptografia App é uma aplicação web que permite aos usuários criptografar e descriptografar textos utilizando o algoritmo AES (Advanced Encryption Standard). A aplicação conta com uma API REST para processar os dados e uma interface web responsiva para interação com o usuário.

## Tecnologias Utilizadas
- **Java 23**
- **Spring Boot 3.1.5** (Framework para criação da API REST)
- **Maven** (Gerenciador de dependências e build)
- **HTML, CSS e JavaScript** (Frontend da aplicação web)
- **JUnit 5** (Testes unitários)
- **AES (Advanced Encryption Standard)** (Algoritmo de criptografia utilizado)

## Arquitetura da Aplicação
A aplicação segue a arquitetura MVC (Model-View-Controller), sendo dividida em:

- **Controller**: Responsável por expor os endpoints da API e tratar as requisições HTTP.
- **Service**: Camada de negócio, onde ocorre a criptografia e descriptografia dos textos.
- **Frontend**: Interface web para interação do usuário com a API.

## Sobre a API
Esta é uma **API RESTful**, o que significa que segue os princípios da arquitetura REST, utilizando requisições HTTP para a comunicação entre cliente e servidor.

### Como funciona?
A API possui dois endpoints principais:

1. **Criptografar Texto**
    - **URL:** `/api/criptografar`
    - **Método:** `POST`
    - **Parâmetro:** `texto` (String a ser criptografada)
    - **Resposta:** Texto criptografado em Base64.

2. **Descriptografar Texto**
    - **URL:** `/api/descriptografar`
    - **Método:** `POST`
    - **Parâmetro:** `textoCriptografado` (String criptografada)
    - **Resposta:** Texto original descriptografado.

Cada requisição é processada pelo `CriptografiaController`, que chama os métodos do `CriptografiaService` para realizar a criptografia e descriptografia utilizando uma chave AES gerada dinamicamente.

## Como Executar o Projeto

### Requisitos
- JDK 17+
- Maven 3+

### Passos
1. Clone o repositório:
   ```sh
   git clone https://github.com/seu-usuario/criptografia-app.git
   ```
2. Navegue até o diretório do projeto:
   ```sh
   cd criptografia-app
   ```
3. Compile e execute a aplicação:
   ```sh
   mvn spring-boot:run
   ```
4. Acesse a interface web no navegador:
   ```sh
   http://localhost:8080
   ```

## Testes
O projeto inclui testes unitários para validar a criptografia e descriptografia dos textos.

Para executar os testes:
```sh
mvn test
```

## Autor
Desenvolvido por **Jardel** 🚀

