
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
		
		String dbName = "TA18_Ejercicio06";
		
		conexion.createDB(dbName); 
		
		conexion.createTable(dbName,"CREATE TABLE Piezas (Codigo INT NOT NULL AUTO_INCREMENT, Nombre NVARCHAR(100) NULL, PRIMARY KEY (Codigo));");
		
		conexion.insertData(dbName,"INSERT INTO Piezas (Nombre) VALUES ('volante');");			
		conexion.insertData(dbName,"INSERT INTO Piezas (Nombre) VALUES ('rueda');");
		conexion.insertData(dbName,"INSERT INTO Piezas (Nombre) VALUES ('transistor');");
		conexion.insertData(dbName,"INSERT INTO Piezas (Nombre) VALUES ('procesador');");
		conexion.insertData(dbName,"INSERT INTO Piezas (Nombre) VALUES ('ram');");
		conexion.insertData(dbName,"INSERT INTO Piezas (Nombre) VALUES ('pila');");
		conexion.insertData(dbName,"INSERT INTO Piezas (Nombre) VALUES ('tubo');");
		conexion.insertData(dbName,"INSERT INTO Piezas (Nombre) VALUES ('tornillo');");
		conexion.insertData(dbName,"INSERT INTO Piezas (Nombre) VALUES ('tuerca');");
		conexion.insertData(dbName,"INSERT INTO Piezas (Nombre) VALUES ('arandela');");
		
		conexion.createTable(dbName,"CREATE TABLE Proveedores (Id CHAR(4) NOT NULL, Nombre NVARCHAR(100) NULL, PRIMARY KEY (Id));");
		
		conexion.insertData(dbName,"INSERT INTO Proveedores (Id, Nombre) VALUES ('1', 'RamonPiezas');");
		conexion.insertData(dbName,"INSERT INTO Proveedores (Id, Nombre) VALUES ('1', 'RamonPiezas');");
		conexion.insertData(dbName,"INSERT INTO Proveedores (Id, Nombre) VALUES ('3', 'Pcmayorist');");
		conexion.insertData(dbName,"INSERT INTO Proveedores (Id, Nombre) VALUES ('4', 'compasElectron');");
		conexion.insertData(dbName,"INSERT INTO Proveedores (Id, Nombre) VALUES ('5', 'ManoloMecanico');");
		conexion.insertData(dbName,"INSERT INTO Proveedores (Id, Nombre) VALUES ('6', 'Manlolamo');");
		conexion.insertData(dbName,"INSERT INTO Proveedores (Id, Nombre) VALUES ('7', 'BenitoRecambios');");
		conexion.insertData(dbName,"INSERT INTO Proveedores (Id, Nombre) VALUES ('8', 'JuanArreglos');");
		conexion.insertData(dbName,"INSERT INTO Proveedores (Id, Nombre) VALUES ('9', 'MIIT');");
		conexion.insertData(dbName,"INSERT INTO Proveedores (Id, Nombre) VALUES ('10', 'PacoMecanic');");
		
		conexion.createTable(dbName,"CREATE TABLE Suministra (CodigoPieza INT NOT NULL, IdProveedor CHAR(4) NOT NULL, Precio INT NULL, PRIMARY KEY (CodigoPieza, IdProveedor), CONSTRAINT ivestigadores_facultad FOREIGN KEY (CodigoPieza) REFERENCES Piezas(Codigo) ON DELETE CASCADE ON UPDATE CASCADE, CONSTRAINT suministra_proveedores FOREIGN KEY (IdProveedor) REFERENCES Proveedores(Id) ON DELETE CASCADE ON UPDATE CASCADE);");
		
		conexion.insertData(dbName,"INSERT INTO Suministra (CodigoPieza, IdProveedor, Precio) VALUES ('2', '1', '32');");
		conexion.insertData(dbName,"INSERT INTO Suministra (CodigoPieza, IdProveedor, Precio) VALUES ('4', '2', '12');");
		conexion.insertData(dbName,"INSERT INTO Suministra (CodigoPieza, IdProveedor, Precio) VALUES ('3', '3', '43');");
		conexion.insertData(dbName,"INSERT INTO Suministra (CodigoPieza, IdProveedor, Precio) VALUES ('6', '4', '21');");
		conexion.insertData(dbName,"INSERT INTO Suministra (CodigoPieza, IdProveedor, Precio) VALUES ('1', '5', '23');");
		conexion.insertData(dbName,"INSERT INTO Suministra (CodigoPieza, IdProveedor, Precio) VALUES ('5', '6', '25');");
		conexion.insertData(dbName,"INSERT INTO Suministra (CodigoPieza, IdProveedor, Precio) VALUES ('10', '7', '14');");
		conexion.insertData(dbName,"INSERT INTO Suministra (CodigoPieza, IdProveedor, Precio) VALUES ('9', '8', '32');");
		conexion.insertData(dbName,"INSERT INTO Suministra (CodigoPieza, IdProveedor, Precio) VALUES ('7', '9', '2');");
		conexion.insertData(dbName,"INSERT INTO Suministra (CodigoPieza, IdProveedor, Precio) VALUES ('8', '10', '4');");
		
	}
	
}