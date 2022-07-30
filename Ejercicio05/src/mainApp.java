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
		
		String dbName = "TA18_Ejercicio05";
		
		conexion.createDB(dbName); 
		
		conexion.createTable(dbName,"CREATE TABLE Despachos( Numero INT, Capacidad INT, PRIMARY KEY (numero) );");
		
		conexion.insertData(dbName,"INSERT INTO Despachos (Numero,Capacidad) VALUE ('1', 5);");		
		conexion.insertData(dbName,"INSERT INTO Despachos (Numero,Capacidad) VALUE ('2', 1);");
		conexion.insertData(dbName,"INSERT INTO Despachos (Numero,Capacidad) VALUE ('3', 3);");		
		conexion.insertData(dbName,"INSERT INTO Despachos (Numero,Capacidad) VALUE ('4', 3);");		
		conexion.insertData(dbName,"INSERT INTO Despachos (Numero,Capacidad) VALUE ('5', 1);");	
		
		conexion.createTable(dbName,"CREATE TABLE Directores( DNI varchar(8), NomApels varchar(255), Despacho int NULL, "
				+ "PRIMARY KEY (DNI), CONSTRAINT Despacho_Asignado FOREIGN KEY (Despacho) REFERENCES Despachos(Numero) ON DELETE SET NULL ON UPDATE CASCADE );");

		conexion.insertData(dbName,"INSERT INTO Directores(DNI,nomApels,despacho) VALUES ('43929334','Esvedlana Astersen',1);");	
		conexion.insertData(dbName,"INSERT INTO Directores(DNI,nomApels,despacho) VALUES ('34160664','Alba Garcia Perez',2);");	
		conexion.insertData(dbName,"INSERT INTO Directores(DNI,nomApels,despacho) VALUES ('46956789','Manu Salas Gomez',3);");	
		conexion.insertData(dbName,"INSERT INTO Directores(DNI,nomApels,despacho) VALUES ('42424897','Federico Chiesa Milan',1);");	
		conexion.insertData(dbName,"INSERT INTO Directores(DNI,nomApels,despacho) VALUES ('35527317','Matt Daymon',1);");
		conexion.insertData(dbName,"INSERT INTO Directores(DNI,nomApels,despacho) VALUES ('48160185','Teresa Paris Hillton',5);");	

	
		conexion.createTable(dbName,"CREATE TABLE Director_Director( Id INT NOT NULL AUTO_INCREMENT, DNI_Director varchar(8),  DNI_Jefe varchar(8),"
				+ " PRIMARY KEY (Id), CONSTRAINT DNI_Subempleado FOREIGN KEY (  DNI_Director ) REFERENCES Directores ( DNI ) ON DELETE CASCADE ON UPDATE CASCADE, "
				+ "CONSTRAINT DNI_Jefe FOREIGN KEY (  DNI_Jefe ) REFERENCES Directores ( DNI ) ON DELETE CASCADE ON UPDATE CASCADE );");
		
		conexion.insertData(dbName,"INSERT INTO Director_Director(DNI_Director,DNI_Jefe) VALUES ('34160664','43929334');");	
		conexion.insertData(dbName,"INSERT INTO Director_Director(DNI_Director,DNI_Jefe) VALUES ('46956789','43929334');");	
		conexion.insertData(dbName,"INSERT INTO Director_Director(DNI_Director,DNI_Jefe) VALUES ('48160185','43929334');");	
		conexion.insertData(dbName,"INSERT INTO Director_Director(DNI_Director,DNI_Jefe) VALUES ('35527317','43929334');");	
		conexion.insertData(dbName,"INSERT INTO Director_Director(DNI_Director,DNI_Jefe) VALUES ('34160664','43929334');");		
	}
	
}
