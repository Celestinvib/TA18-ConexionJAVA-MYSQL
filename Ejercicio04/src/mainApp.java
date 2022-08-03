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
		
		String dbName = "TA18_Ejercicio04";
		
		conexion.createDB(dbName); 
		
		conexion.createTable(dbName,"CREATE TABLE peliculas (CODIGO int NOT NULL, NOMBRE varchar(255) NOT NULL, CALIFICACIONEDAD varchar(255) DEFAULT NULL, PRIMARY KEY (CODIGO));");
		
		conexion.insertData(dbName,"INSERT INTO peliculas VALUES (1,'Citizen Kane','PG'),(2,'Singin\\' in the Rain','G'),(3,'The Wizard of Oz','G'),(4,'The Quiet Man',NULL),(5,'North by Northwest',NULL),(6,'The Last Tango in Paris','NC-17'),(7,'Some Like it Hot','PG-13'),(8,'A Night at the Opera',NULL),(9,'Citizen King','G');");			
		
		conexion.createTable(dbName,"CREATE TABLE salas (CODIGO int NOT NULL, NOMBRE varchar(255) NOT NULL, PELICULA int DEFAULT NULL, PRIMARY KEY (CODIGO), KEY PELICULA (PELICULA), CONSTRAINT salas_ibfk_1 FOREIGN KEY (PELICULA) REFERENCES peliculas (CODIGO));");
		
		conexion.insertData(dbName,"INSERT INTO salas VALUES (1,'Odeon',5),(2,'Imperial',1),(3,'Majestic',NULL),(4,'Royale',6),(5,'Paraiso',3),(6,'Nickelodeon',NULL);");
	}
	
}