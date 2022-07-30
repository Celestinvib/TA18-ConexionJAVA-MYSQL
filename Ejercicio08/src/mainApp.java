import SQLConnection.SQLConnection;

public class mainApp {

	public static void main(String[] args) {
	SQLConnection conexion = new SQLConnection();			
		
		structureCreation(conexion);
		
		conexion.closeConnection();		
	}
	
	/**
	* Metodo donde se realiza la creacion de la estructura mysql con datos estaticos
	*/
	public static void structureCreation(SQLConnection conexion) {
		
		String dbName = "TA18_Ejercicio08";
		
		conexion.createDB(dbName); 
		
		conexion.createTable(dbName,"CREATE TABLE Cajeros( Codigo INT, NomApels varchar(255), PRIMARY KEY (Codigo) );");
	
		conexion.insertData(dbName,"INSERT INTO Cajeros(Codigo, NomApels) VALUES (1,'Paco Leon Salas');");		
		conexion.insertData(dbName,"INSERT INTO Cajeros(Codigo, NomApels) VALUES (2,'Clara Ogalla Salas');");
		conexion.insertData(dbName,"INSERT INTO Cajeros(Codigo, NomApels) VALUES (3,'Samuel de Luque');");		
		conexion.insertData(dbName,"INSERT INTO Cajeros(Codigo, NomApels) VALUES (4,'Guillermo Doblas Beltran');");		
		conexion.insertData(dbName,"INSERT INTO Cajeros(Codigo, NomApels) VALUES (5,'John Doe');");	
		
		conexion.createTable(dbName,"CREATE TABLE Productos( Codigo INT, Nombre varchar(100), Precio INT, PRIMARY KEY (Codigo) );");

		conexion.insertData(dbName,"INSERT INTO Productos(Codigo,Nombre,Precio) VALUES(1,'Pack6 Yogurt Griego Sabor Fresa',3);");		
		conexion.insertData(dbName,"INSERT INTO Productos(Codigo,Nombre,Precio) VALUES(2,'Caja de Cereales CornFlake',2);");		
		conexion.insertData(dbName,"INSERT INTO Productos(Codigo,Nombre,Precio) VALUES(3,'Agua 1,5L FontVella',1);");		
		conexion.insertData(dbName,"INSERT INTO Productos(Codigo,Nombre,Precio) VALUES(4,'Agua 6L FontVella',3);");		
		conexion.insertData(dbName,"INSERT INTO Productos(Codigo,Nombre,Precio) VALUES(5,'Fuet espatec',2);");		

		conexion.createTable(dbName,"CREATE TABLE Maquinas_Registradoras( Codigo INT , Piso INT, PRIMARY KEY (Codigo) );");

		conexion.insertData(dbName,"INSERT INTO Maquinas_Registradoras(Codigo,Piso) VALUES(1,1);");		
		conexion.insertData(dbName,"INSERT INTO Maquinas_Registradoras(Codigo,Piso) VALUES(2,1);");		
		conexion.insertData(dbName,"INSERT INTO Maquinas_Registradoras(Codigo,Piso) VALUES(3,2);");		
		conexion.insertData(dbName,"INSERT INTO Maquinas_Registradoras(Codigo,Piso) VALUES(4,2);");		
		conexion.insertData(dbName,"INSERT INTO Maquinas_Registradoras(Codigo,Piso) VALUES(5,3);");	
		
		conexion.createTable(dbName,"CREATE TABLE Ventas( Codigo INT NOT NULL AUTO_INCREMENT, Cajero INT, Maquina INT, Producto INT, PRIMARY KEY (Codigo),"
				+ " CONSTRAINT codigo_cajero FOREIGN KEY ( Cajero ) REFERENCES Cajeros( Codigo ) ON DELETE SET NULL ON UPDATE CASCADE, "
				+ "CONSTRAINT codigo_producto FOREIGN KEY ( Producto ) REFERENCES Productos( Codigo ) ON DELETE SET NULL ON UPDATE CASCADE,"
				+ " CONSTRAINT codigo_maquina_registradora FOREIGN KEY ( Maquina ) REFERENCES Maquinas_Registradoras( Codigo ) ON DELETE SET NULL ON UPDATE CASCADE );;");

		
		conexion.insertData(dbName,"INSERT INTO Ventas(Cajero,Maquina,Producto) VALUES (1,2,4);");		
		conexion.insertData(dbName,"INSERT INTO Ventas(Cajero,Maquina,Producto) VALUES (1,2,1);");		
		conexion.insertData(dbName,"INSERT INTO Ventas(Cajero,Maquina,Producto) VALUES (1,2,2);");		
		conexion.insertData(dbName,"INSERT INTO Ventas(Cajero,Maquina,Producto) VALUES (1,2,5);");		
		conexion.insertData(dbName,"INSERT INTO Ventas(Cajero,Maquina,Producto) VALUES (2,1,1);");		
	}
	
}
