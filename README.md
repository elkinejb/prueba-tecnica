Diagrama realcional de bases de datos

<img width="567" height="546" alt="image" src="https://github.com/user-attachments/assets/dc367416-d4aa-45d3-8c40-719742080a0a" />


comands to run the proyect:

#clone a repository
git clone "link del repositorio"

#install all dependencis

npm install      #mirar si tenemos instalado npm, si no instalar con pip install npm
node install     # mirar si tenemos node instalado para el funcionamiento si no instalar con pip install node

#intalar todas las dependencias de angular
ng install

#crear un proyecto angular importando todas las librerias y dependencias de este framework
ng new "nombre del proyecto"


base de datos:

#Crear la base de datos
CREATE DATABASE sistema_ventas;

#Conectarse a la base de datos
\c sistema_ventas;

#2. Crear tabla Vendedor
CREATE TABLE Vendedor (
    id_vendedor SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL,
    telefono VARCHAR(20)
);

#3. Crear tabla Producto
CREATE TABLE Producto (
    id_producto SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio NUMERIC(12,2) NOT NULL CHECK (precio >= 0),
    stock INT NOT NULL CHECK (stock >= 0)
);

#4. Crear tabla Venta
CREATE TABLE Venta (
    id_venta SERIAL PRIMARY KEY,
    id_producto INT NOT NULL,
    id_vendedor INT NOT NULL,
    cantidad INT NOT NULL CHECK (cantidad > 0),
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_producto
        FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk_vendedor
        FOREIGN KEY (id_vendedor) REFERENCES Vendedor(id_vendedor)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

#5. Relaciones:
-- Una venta pertenece a un producto y a un vendedor
-- Un producto puede aparecer en muchas ventas
-- Un vendedor puede realizar muchas ventas
