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
	* Metodo donde se realiza la creacion de la estructura mysql con datos staticos
	*/
	public static void structureCreation(SQLConnection conexion) {
		
		String dbName = "TA18_Ejercicio02";
		
		conexion.createDB(dbName); 
		
		conexion.createTable(dbName,"CREATE TABLE Departamentos (Codigo INT PRIMARY KEY , Nombre VARCHAR (50) , Presupuesto INT)");
		
		conexion.insertData(dbName,"INSERT INTO Departamentos (Codigo,Nombre,Presupuesto) VALUE ('1','IT',80000);");		
		conexion.insertData(dbName,"INSERT INTO Departamentos (Codigo,Nombre,Presupuesto) VALUE ('2','Research',50000);");		
		conexion.insertData(dbName,"INSERT INTO Departamentos (Codigo,Nombre,Presupuesto) VALUE ('3','Accounting',44000);");		
		conexion.insertData(dbName,"INSERT INTO Departamentos (Codigo,Nombre,Presupuesto) VALUE ('4','Human Resourcing',70000);");		
		conexion.insertData(dbName,"INSERT INTO Departamentos (Codigo,Nombre,Presupuesto) VALUE ('5','Technology',20000);");	
		
		
		conexion.createTable(dbName,"CREATE TABLE Empleados (DNI VARCHAR(8) PRIMARY KEY, Nombre VARCHAR (100) , Apellidos VARCHAR (255), Departamento INT NULL, CONSTRAINT departamento FOREIGN KEY (Departamento) REFERENCES Departamentos(Codigo) ON DELETE SET NULL  ON UPDATE CASCADE)");

		conexion.insertData(dbName,"INSERT INTO Empleados (DNI,Nombre, Apellidos, Departamento) VALUE ('46423897','Ceres','García Pérez','1');");		
		conexion.insertData(dbName,"INSERT INTO Empleados (DNI,Nombre, Apellidos, Departamento) VALUE ('48425309','Jose','Piqué Chiesa','2');");
		conexion.insertData(dbName,"INSERT INTO Empleados (DNI,Nombre, Apellidos, Departamento) VALUE ('41539450','Clara','Ruiz Ruiz','3');");	
		conexion.insertData(dbName,"INSERT INTO Empleados (DNI,Nombre, Apellidos, Departamento) VALUE ('48391395','Aroa','Mendoza','4');");	
		conexion.insertData(dbName,"INSERT INTO Empleados (DNI,Nombre, Apellidos, Departamento) VALUE ('41277319','Mark','Garcia','5');");	
			}
	
	
	

	
	
}
