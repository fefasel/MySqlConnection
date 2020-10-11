
//must for connection
package mySqlJavaConnection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;




public class App {
	
	private final String userName = "root";
	private final String password = "root";
	private final String localhostIp = "127.0.0.1";
	
	
	private final String db = "hibernate";
	private final int port = 3306;
	
	
	
	//this is needed
	private Connection con = null;
	
	
	public void initialize() {
		String url = "jdbc:mysql://"+this.localhostIp+":"+this.port+"/"+this.db;
		
		
		//checks if mysql connecter is connected or not
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e) {
			System.out.println("MySql Connecter didnt connect");
			e.printStackTrace();
		}
		
		//try to make connection
		try {
			this.con = DriverManager.getConnection(url,userName,password);
		}catch(SQLException e) {
			System.out.print("Connection is failed.");
			e.printStackTrace();
		}
		
		//if we made connection above, we come here and we gotta check again
		if(con!=null) {
			System.out.print("SUCCESFULL CONNECTION");
		}else {
			System.out.print("failed connection!!");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		App myApp = new App();
		myApp.initialize();
		
		

	}

}
