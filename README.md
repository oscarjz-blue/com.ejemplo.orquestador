# com.ejemplo.orquestador
Ejemplo CRUD sistema financiero

Para creacion de la estructura de un proyecto Maven en Java 17 y sus dependencias seria de la siguiente manera:

https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.3.9&packaging=jar&jvmVersion=17&groupId=com.ejemplo&artifactId=orquestador&name=orquestador&description=Demo%20project%20for%20Spring%20Boot&packageName=com.ejemplo.orquestador&dependencies=web,cloud-config-client,h2,data-jpa,lombok,cloud-feign

Para levantar el proyecto se puede hacer de la siguiente manera:
- mvn spring-boot:run

Una vez que el proyecto esta levantado podemos usar Swagger para probar el CRUD de cliente, cuenta y movimientos:
- http://localhost:10001/swagger-ui/index.html#/

Conexion con H2 mediante el browser, con la posibilidad de ver las tablas y hacer un SELECT a cada una lo haremos con el siguiente link:
- http://localhost:10001/h2-console/


La arquitectura propuesta es Orquestador, y por la consigna decidi que los microservicios de cliente, cuenta, movimientos esten integrados a los efectos practicos:
Observacion: tiene un solo llamado a servicio "externo" mediante un ClienteClient (con feign)

![imagen](https://github.com/user-attachments/assets/52a557d3-7552-484d-aec0-f147a06fba51)

Ejemplo de creacion de un cliente, una cuenta y un movimiento:

POST:/api/clientes
JSON:
{
"id": 0,
"nombre": "oscar",
"email": "oscar@email.com"
}

POST:/api/cuentas
JSON:
{
"id": 0,
"numeroCuenta": "123456789",
"saldo": 1000,
"cliente": {
"id": 1,
"nombre": "oscar",
"email": "oscar@email.com"
}
}

POST:/api/movimientos
JSON:
{
"id": 0,
"monto": 500,
"tipo": "DEBITO",
"cuenta": {
"id": 1,
"numeroCuenta": "123456789",
"saldo": 500,
"cliente": {
"id": 1,
"nombre": "oscar",
"email": "oscar@email.com"
}
}
}

Consultas de datos mediante SQL:
- SELECT * FROM CLIENTE
- SELECT * FROM CUENTA
- SELECT * FROM MOVIMIENTO 
