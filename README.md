# API-REST-Spring-Tutorial
La API REST que verán en este proyecto se desarrolló en Eclipse IDE Enterprise con Spring Boot y Java (versiones de ambos más actuales hasta la fecha) y una base de datos PostgreSQL. Se trata de una pequeña demo tutorial para conocer el funcionamiento de Spring. Fue desarrollada a partir del siguiente curso https://www.youtube.com/watch?v=9SGDpanrc8U&ab_channel=Amigoscode además me tomé la libertad de dejar varios comentarios en el código para facilitar la comprensión de Spring Boot a otros interesados en su aprendizaje.

La API genera como base dos estudiantes que guarda en la base de datos. Está desarrollada en tres capas: la capa API (GET, POST, PUT, DELETE), una capa de servicios y finalmente una capa de acceso a los datos antes de llegar a la base de datos.

En la carpeta del proyecto llamada Pruebas con Postman, pueden encontrar capturas de la API probada con la herramienta antes mencionada.

Si quieren descargar y trabajar sobre este proyecto tengan en cuenta lo siguiente:
1. Tienes que tener instalado PostgreSQL. Puedes descargarlo aquí según tu Sistema Operativo https://www.enterprisedb.com/downloads/postgres-postgresql-downloads mientras lo instalas, recuerda el usuario y contraseña que pongas.
2. Deben editar el archivo application.properties colocando el nombre de usuario y la contraseña que utilizaron al instalar PostgreSQL. El archivo se encuentra en src > main > resources
3. Es necesario tener la base de datos con la que vas a trabajar. A continuación te dejo los pasos para crear tu base de datos.

### Creación de la base de datos
1. en el buscador de windows poner SQL SHELL y entrar a la consola.
2. Dar enter varias veces (no rellenar nombre de usuario) hasta que pida la password (que no se verá en pantalla cuando teclees), entonces coloca la pass que usaste en la instalación.
3. Escribe: create database estudiante;
4. Escribe: \du (para ver los usuarios de tu sistema)
5. Escribe: GRANT ALL PRIVILEGES ON DATABASE "estudiante" TO postgres;    *postgres es el nombre de usuario por defecto. Si tienes más usuarios (los viste en el paso anterior) repite la misma línea para cada usuario*
6. Escribir: \l (para ver el listado de bases de datos que tenemos).
7. Escribir: \c estudiante (se conecta a la base de datos)
Una vez conectado puedes hacer consultas en el idioma de la BD, por ejemplo: SELECT * FROM estudiante;
