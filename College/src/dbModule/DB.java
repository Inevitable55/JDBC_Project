package dbModule;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class DB {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:/**//college";                             //Add port number
		  String username = "";                                                         //Add Username
		  String password = "";                                                         //Add Password
		  
		  try {
			Connection connection = DriverManager.getConnection(url,username,password);
			System.out.println("Connection successfully");
			
			try
			{
				String query = "INSERT INTO data (Name,Email,Phno) VALUES (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(query);		
			
			statement.setString(2, "Kshitij.kanojiyarockz@gmail.com");
			statement.setString(3, "56");
			statement.setString(1, "orospeu");
			
			statement.executeUpdate();
			int rows = statement.executeUpdate();
				
			if(rows>0) {
			 System.out.println("A row has been inserted");
			}
			statement.close();
			connection.close();
			System.out.println("query executed successfully");
			}catch (Exception e){
				//System.out.println("Error in executing the query");
				System.out.println(e);
			}

		  } catch (SQLException e) {
         System.out.println("Error in connection to Database ");
			e.printStackTrace();
		}	
	}
  
  
}
