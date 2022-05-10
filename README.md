# API-REST-Spring-Tutorial
La API REST que verán en este proyecto se desarrolló en Eclipse IDE Enterprise con Spring Boot y Java (versiones de ambos más actuales hasta la fecha) y una base de datos PostgreSQL. Se trata de una pequeña demo tutorial para conocer el funcionamiento de Spring. Fue desarrollada a partir del siguiente curso https://www.youtube.com/watch?v=9SGDpanrc8U&ab_channel=Amigoscode además me tomé la libertad de dejar varios comentarios en el código para facilitar la comprensión de Spring Boot a otros interesados en su aprendizaje.

La API genera como base dos estudiantes que guarda en la base de datos. Está desarrollada en tres capas: la capa API (GET, POST, PUT, DELETE), una capa de servicios y finalmente una capa de acceso a los datos antes de llegar a la base de datos.

En la carpeta del proyecto llamada Pruebas con Postman, pueden encontrar capturas de la API probada con la herramienta antes mencionada.

Si quieren descargar y trabajar sobre este proyecto tengan en cuenta lo siguiente:
1. Deben editar el archivo application.properties colocando el nombre de usuario y la contraseña que utilizaron al instalar PostgreSQL. El archivo se encuentra en src > main > resources
