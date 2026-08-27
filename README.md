# Atividade 01 - API REST de Clima

API REST em Spring Boot para consultar dados meteorológicos via WeatherAPI.

## Requisitos
- Java
- Maven
- API Key da [WeatherAPI](https://www.weatherapi.com/)

## Configuração
No projeto, abra o arquivo `src/main/resources/application.properties` e adicione a sua chave:

weather.api.key=SUA_CHAVE_AQUI

## Execução
Rode a aplicação direto pela sua IDE ou utilize o comando no terminal:

./mvnw spring-boot:run

## Endpoints
- **Belo Horizonte (Padrão):** 
  `GET http://localhost:8080/clima`

- **Outras Cidades (Desafio):** 
  `GET http://localhost:8080/clima/{cidade}` 
  *(Exemplo: http://localhost:8080/clima/Curitiba)*