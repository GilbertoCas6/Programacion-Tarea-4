Proyecto de Tarea 4 - Sistema de Login
Este es un sistema de login y registro que desarrollé para la Tarea 4. Permite a los usuarios registrarse y luego iniciar sesión en una interfaz gráfica simple. El proyecto está hecho en Java con Swing para la interfaz, y se conecta a una base de datos MySQL para guardar los usuarios.

Cómo usarlo
Instalar Java y MySQL: Asegúrate de tener Java (JDK 8 o superior) y MySQL instalados en tu máquina.

Base de Datos: Crea una base de datos en MySQL llamada login_db y una tabla de usuarios con este código SQL:

CREATE DATABASE login_db;
USE login_db;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    usuario VARCHAR(50) UNIQUE NOT NULL,
    telefono VARCHAR(15) NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL,
    contraseña VARCHAR(255) NOT NULL
);

Agregar un usuario para probar el login:

INSERT INTO usuarios (nombre, apellido, usuario, telefono, correo, contraseña) 
VALUES ('Juan', 'Pérez', 'juan123', '123456789', 'juan@example.com', '12345');

Configurar la conexión: Asegúrate de que las credenciales en la clase ConexionBD.java sean correctas (usuario y contraseña de tu MySQL).

Ejecutar el proyecto: Corre la clase LoginUI.java. Ahí se abrirá la ventana donde podrás registrarte o iniciar sesión.

Notas

**Errores comunes: Si no puedes conectar a la base de datos, revisa que MySQL esté activo y que las credenciales estén bien configuradas.**

