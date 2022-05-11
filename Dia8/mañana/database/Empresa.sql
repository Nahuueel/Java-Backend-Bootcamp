CREATE TABLE cliente(
    id int AUTO_INCREMENT,
    nombre varchar(30) NOT NULL,
    apellido varchar(60) NOT NULL,
    dni varchar(15) NOT NULL,
    direccion varchar(50) NOT NULL,
	fechanacimien varchar(15) NOT NULL,
    PRIMARY KEY(id)
) ENGINE = INNODB;

CREATE TABLE vendedor(
	id int AUTO_INCREMENT,
    nombre varchar(30) NOT NULL,
    apellido varchar(60) NOT NULL,
    dni varchar(15) NOT NULL,
    direccion varchar(50) NOT NULL,
    salario int NOT NULL,
    fechanacimien varchar(15) NOT NULL,
    PRIMARY KEY(id)   
)ENGINE = INNODB;

CREATE TABLE productos(
    id int AUTO_INCREMENT,
    codigo varchar(10) NOT NULL,
    precio int NOT NULL,
    cantidad int NOT NULL,
    stockm int NOT NULL,
   	PRIMARY KEY(id)
)ENGINE = INNODB;


CREATE TABLE facturacion(
	id int AUTO_INCREMENT,
    numfactura int NOT NULL,
    fechacompra varchar(15) NOT NULL,
    clientefk varchar(30) NOT NULL,
    vendedorfk varchar(30) NOT NULL,
    productofk varchar(10) NOT NULL,
	PRIMARY KEY(id),
	CONSTRAINT FK_cliente
    FOREIGN KEY(clientefk) REFERENCES cliente(nombre),
    CONSTRAINT FK_vendedor
    FOREIGN KEY(vendedorfk) REFERENCES vendedor(nombre),
	CONSTRAINT FK_producto
    FOREIGN KEY(productofk) REFERENCES productos(codigo)
)ENGINE = INNODB;

CREATE TABLE facturacion(
	id int AUTO_INCREMENT,
    numfactura int NOT NULL,
    fechacompra varchar(15) NOT NULL,
    clientefk varchar(30) NOT NULL,
    vendedorfk varchar(30) NOT NULL,
    productofk varchar(10) NOT NULL,
	PRIMARY KEY(id),
    FOREIGN KEY(clientefk) REFERENCES cliente(nombre),
    FOREIGN KEY(vendedorfk) REFERENCES vendedor(nombre),
    FOREIGN KEY(productofk) REFERENCES productos(codigo)
)ENGINE = INNODB;