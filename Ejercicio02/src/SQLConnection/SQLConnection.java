package SQLConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class SQLConnection {
	
	public Connection conexion;
	
	
	public SQLConnection () {
		makeConection();
	}
	
	/**
	* Metodo donde el usuario introduce los datos de su servidor/sql y se establece la conexion
	*/
	public void makeConection() {
	    String ip = JOptionPane.showInputDialog(null,"Introduce los datos de la conexión sql\nIp:"); 

	    String user = JOptionPane.showInputDialog(null,"Usuario: ");

	    String pass = JOptionPane.showInputDialog(null,"Contraseña: ");
	    
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://"+ip+":3306?useTimezone=true&serverTimezone=UTC",user,pass);
			JOptionPane.showMessageDialog(null,"Conectado al Sevidor");				
		}catch (SQLException | ClassNotFoundException ex ) {
			System.out.println("No se ha podido conectar con mi base de datos");
			System.out.println(ex);
		}
	}
	
	/**
	* Metodo que cierra la conexion
	*/
	public void closeConnection() {
		
		try {
			conexion.close();
			JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión con el servidor");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	
	/**
	* Metodo que crea una base de datos con el nombre indicado
	* @param name nombre de la base datos
	*/	
	public void createDB(String name) {
				
		try {
			String Query = "CREATE DATABASE "+name;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			JOptionPane.showMessageDialog(null,"Se ha creado la base de datos "+name+ " de forma exitosa");					
		}catch (SQLException ex) {
			
		}
	}
	
	/**
	* Metodo que crea una tabla 
	* @param db nombre de la base datos donde se creara la tabla
	* @param SQLquery sentencia sql de la creacion de la tabla
	*/		
	public void createTable(String db,String SQLquery) {
		
		try {
			String Querydb = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			Statement st = conexion.createStatement();
			st.executeUpdate(SQLquery);
			JOptionPane.showMessageDialog(null, "Tabla Creada con exito!");
			
		}catch (SQLException ex)  {
			JOptionPane.showMessageDialog(null,"Error: "+ex.getMessage());
		}
		
	}
	
	/**
	* Metodo que inserta datos en una tabla
	* @param db nombre de la base datos donde se insertaran los datos
	* @param SQLquery sentencia sql de la insercion de los datos en la tabla
	*/	
	public void insertData (String db, String SQLquery) {
		
		try {
			String Querydb = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			Statement st = conexion.createStatement();
			st.executeUpdate(SQLquery);
			System.out.println("Insert sobre la tabla realizado correctamente");			
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error: "+ex.getMessage());
		}
	}
}
