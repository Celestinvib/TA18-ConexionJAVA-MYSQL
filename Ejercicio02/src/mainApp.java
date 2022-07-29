import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.mysql.cj.MysqlConnection;

public class mainApp {
	
	public static Connection conexion;
	
	public static void main(String[] args) {
		
		makeConection();
		createDB("TA18_Ejercicio02");
		createTable("TA18_Ejercicio02","CREATE TABLE Departamentos (Codigo INT PRIMARY KEY AUTO_INCREMENT, Nombre VARCHAR (50) , Presupuesto INT)");
		insertData("TA18_Ejercicio02","INSERT INTO Departamentos (Nombre,Presupuesto) VALUE ('IT',80000);");		
		insertData("TA18_Ejercicio02","INSERT INTO Departamentos (Nombre,Presupuesto) VALUE ('Research',50000);");		
		insertData("TA18_Ejercicio02","INSERT INTO Departamentos (Nombre,Presupuesto) VALUE ('Accounting',44000);");		
		insertData("TA18_Ejercicio02","INSERT INTO Departamentos (Nombre,Presupuesto) VALUE ('Human Resourcing',70000);");		
		insertData("TA18_Ejercicio02","INSERT INTO Departamentos (Nombre,Presupuesto) VALUE ('Technology',20000);");		
		JOptionPane.showMessageDialog(null,"Datos almacenos correctamente");

		createTable("TA18_Ejercicio02","CREATE TABLE Empleados (DNI VARCHAR(8) PRIMARY KEY, Nombre VARCHAR (100) , Apellidos VARCHAR (255), Departamento INT NULL, CONSTRAINT departamento FOREIGN KEY (Departamento) REFERENCES Departamentos(Codigo) ON DELETE SET NULL  ON UPDATE CASCADE)");
		insertData("TA18_Ejercicio02","INSERT INTO Empleados (DNI,Nombre, Apellidos, Departamento) VALUE ('46423897','Ceres','García Pérez','1');");		
		insertData("TA18_Ejercicio02","INSERT INTO Empleados (DNI,Nombre, Apellidos, Departamento) VALUE ('48425309','Jose','Piqué Chiesa','2');");
		insertData("TA18_Ejercicio02","INSERT INTO Empleados (DNI,Nombre, Apellidos, Departamento) VALUE ('41539450','Clara','Ruiz Ruiz','3');");	
		insertData("TA18_Ejercicio02","INSERT INTO Empleados (DNI,Nombre, Apellidos, Departamento) VALUE ('48391395','Aroa','Mendoza','4');");	
		insertData("TA18_Ejercicio02","INSERT INTO Empleados (DNI,Nombre, Apellidos, Departamento) VALUE ('41277319','Mark','Garcia','5');");	
		JOptionPane.showMessageDialog(null,"Datos almacenos correctamente");

		closeConnection();
		
	}
	
	public static void makeConection() {
		//192.168.1.47
	    String ip = JOptionPane.showInputDialog(null,"Introduce los datos de la conexión sql\nIp:"); 

	    String user = JOptionPane.showInputDialog(null,"Usuario: ");

	    String pass = JOptionPane.showInputDialog(null,"Contraseña: ");
	    
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://"+ip+":3306?useTimezone=true&serverTimezone=UTC",user,pass);
			JOptionPane.showMessageDialog(null,"Server Connected");				
		}catch (SQLException | ClassNotFoundException ex ) {
			System.out.println("No se ha podido conectar con mi base de datos");
			System.out.println(ex);
		}
	}
	
	public static void closeConnection() {
		
		try {
			conexion.close();
			JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión con el servidor");
		} catch (SQLException ex) {
//			Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	
	public static void createDB(String name) {
				
		try {
			String Query = "CREATE DATABASE "+name;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
//			MySQLConnection("remote","P@ssw0rd","DATaBASE");
			JOptionPane.showMessageDialog(null,"Se ha creado la base de datos "+name+ " de forma exitosa");					
		}catch (SQLException ex) {
			
		}
	}
	
	public static void createTable(String db,String SQLquery) {
		
		try {
			String Querydb = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			Statement st = conexion.createStatement();
			st.executeUpdate(SQLquery);
			JOptionPane.showMessageDialog(null, "Tabla Creada con exito!");
			
		}catch (SQLException ex)  {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla.");
		}
		
	}
	public static void insertData (String db, String SQLquery) {
		
		try {
			String Querydb = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			Statement st = conexion.createStatement();
			st.executeUpdate(SQLquery);
			
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}
	
	
}
