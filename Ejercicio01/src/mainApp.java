import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.mysql.cj.MysqlConnection;

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
		
		String dbName = "TA18_Ejercicio01";
		
		conexion.createDB(dbName); 
		
		conexion.createTable(dbName,"CREATE TABLE Fabricantes (CODIGO int NOT NULL, NOMBRE varchar(255) NOT NULL, PRIMARY KEY (CODIGO));");
		
		conexion.insertData(dbName,"INSERT INTO Fabricantes VALUES (1,'Sony'),(2,'Creative Labs'),(3,'Hewlett-Packard'),(4,'Iomega'),(5,'Fujitsu'),(6,'Winchester');");			
		
		conexion.createTable(dbName,"CREATE TABLE Articulos (CODIGO int NOT NULL, NOMBRE varchar(255) NOT NULL, PRECIO decimal(10,0) NOT NULL, FABRICANTE int NOT NULL, PRIMARY KEY (CODIGO), KEY FABRICANTE (FABRICANTE), CONSTRAINT articulos_ibfk_1 FOREIGN KEY (FABRICANTE) REFERENCES Fabricantes (CODIGO));");
		
		conexion.insertData(dbName,"INSERT INTO Articulos VALUES (1,'Hard drive',240,5),(2,'Memory',120,6),(3,'ZIP drive',150,4),(4,'Floppy disk',5,6),(5,'Monitor',240,1),(6,'DVD drive',180,2),(7,'CD drive',90,2),(8,'Printer',270,3),(9,'Toner cartridge',66,3),(10,'DVD burner',180,2);");
	}
	
}
