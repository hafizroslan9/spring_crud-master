package net.codeJava;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.Statement;
public class ContactProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Statement statement = null;
		try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://ec2-34-193-112-164.compute-1.amazonaws.com:5432/d7jdcs2gd3carr", "azxcuqwjjdmxwi", "5894ea67c1b0c0ade677dfa6ed46eccb3ec87b725b9321971cdbf7008674901a")) {
			
            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
            
            //String query = "insert into public.\"Product\"(\"productId\",\"productName\",\"productQuantity\",\"productPrice\",\"productDescription\",\"productType\")" + "values('','','','','','')";
           // statement = conn.createStatement();
            //statement.executeUpdate(query);
            //System.out.println("The data has been insert successfully");
            
            
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
		 
	}
}

