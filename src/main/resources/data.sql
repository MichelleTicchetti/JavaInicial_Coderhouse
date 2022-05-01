CREATE TABLE EMPRESA (
ID_EMPRESA INT NOT NULL AUTO_INCREMENT,
RAZON_SOCIAL VARCHAR(50) NOT NULL,
RUBRO VARCHAR(100) NOT NULL,
CUIT VARCHAR(11) NOT NULL,
PRIMARY KEY (CUIT)
);

CREATE TABLE SUCURSALES(
ID_SUCURSAL INT NOT NULL AUTO_INCREMENT,
NOMBRE VARCHAR(25) NOT NULL,
DIRECCION VARCHAR(50) NOT NULL,
TELEFONO VARCHAR (15) NOT NULL,
PRIMARY KEY(ID_SUCURSAL)
);

CREATE TABLE CLIENTES (
ID_CLIENTE INT NOT NULL AUTO_INCREMENT,
NOMBRE VARCHAR(150) NOT NULL,
APELLIDO VARCHAR(150) NOT NULL,
FECHA_NACIMIENTO DATE NOT NULL,
DNI VARCHAR (8) NOT NULL,
TELEFONO VARCHAR (15) NOT NULL,
DIRECCION VARCHAR (150) NOT NULL,
EMAIL VARCHAR(50),
PRIMARY KEY (ID_CLIENTE)
);

CREATE TABLE COMPRAS (
ID_COMPRA INT NOT NULL AUTO_INCREMENT,
FECHA DATETIME NOT NULL,
PRECIO_TOTAL DOUBLE NOT NULL,
PRIMARY KEY (ID_COMPRA)
);

CREATE TABLE ITEMS (
ID_ITEM INT NOT NULL AUTO_INCREMENT,
CANTIDAD INT NOT NULL,
PRECIO_SUBTOTAL DOUBLE NOT NULL,
PRIMARY KEY (ID_ITEM)
);

CREATE TABLE PRODUCTOS (
ID_PRODUCTO INT NOT NULL AUTO_INCREMENT,
NOMBRE VARCHAR(150) NOT NULL,
DESCRIPCION VARCHAR (250),
PLATAFORMA VARCHAR(15) NOT NULL,
CATEGORIA VARCHAR(150) NOT NULL,
STOCK INT NOT NULL,
PRECIO_UNITARIO DOUBLE NOT NULL,
PRIMARY KEY (ID_PRODUCTO)
);

INSERT INTO EMPRESA(RAZON_SOCIAL, RUBRO, CUIT)
VALUES('Gaming.SA', 'Comercio de videojuegos', '27280335148');

INSERT INTO SUCURSALES(NOMBRE, DIRECCION, TELEFONO)
VALUES('Jardin Botanico', 'Av.Santa Fe 3954', '47765896'), ('Microcentro', 'Av. Belgrano 442', '47586525');


INSERT INTO CLIENTES (NOMBRE, APELLIDO, FECHA_NACIMIENTO, DNI, TELEFONO, DIRECCION, EMAIL )
VALUES ('Luis', 'Carrasco', '1957-10-25' , '30598653', '1165945223', 'Av Santa Fe 2562 2C', 'luis.carrasco@gmail.com'),
('Antonio', 'Lopez', '1960-08-15' , '31569558', '1156511485', 'Paraguay 4863','a.lopez@gmail.com'),
('Maria', 'Cruz', '2002-02-11' , '40698561', '1166631542', 'Av. Las Heras 6953', 'macruz@gmail.com'),
('Isabela', 'Rodriguez', '1989-09-18' , '37965485', '1163124895', 'Larrea 3265 4B','isa-rodriguez@gmail.com'),
('Roberto', 'Arce', '1978-06-05' , '34666248', '1165722353', 'Entre Rios 1365', 'robertoarce@gmail.com');

INSERT INTO PRODUCTOS(NOMBRE, DESCRIPCION, PLATAFORMA, CATEGORIA, STOCK, PRECIO_UNITARIO )
VALUES('The Last Of Us', 'Edición especial', 'PS4', 'Accion', 200, 5999),
('Minecraft', 'Plus Package Batman Skins', 'PS4', 'Aventura', 250, 5565),
('Read Dead Redemption 2', null, 'XBOX ONE', 'Accion', 300, 4499),
('Read Dead Redemption 2', null, 'PS4', 'Accion', 300, 4499),
('FIFA2022', null, 'PS4', 'Deporte', 200, 7499),
('FIFA2022', null, 'XBOX ONE', 'Deporte', 150, 7499),
('GTA V', null, 'PS4', 'Accion', 50, 5300),
('Dying Light', null, 'PS4', 'Terror', 120, 10000),
('BioShock', 'The Collection', 'Nintendo Switch', 'Accion', 50, 8700),
('NBA2k21', null, 'XBOX ONE', 'Deporte', 150, 2000);


