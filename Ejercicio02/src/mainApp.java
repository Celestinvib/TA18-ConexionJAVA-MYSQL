import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class mainApp {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);

	    System.out.print("Introduce los datos de la conexión sql\nIp:");
	    String ip = sc.nextLine();
	    System.out.print("Usuario: ");
	    String user = sc.nextLine();
	    System.out.print("Contraseña: ");
	    String pass = sc.nextLine();
	    
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://"+ip+":3306?useTimezone=true&serverTimezone=UTC",user,pass);
			System.out.println("Server Connected");	
			
		}catch (SQLException | ClassNotFoundException ex ) {
			System.out.println("No se ha podido conectar con mi base de datos");
			System.out.println(ex);
		}
	}
}
