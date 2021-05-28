import java.sql.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addProductServlet
 */
@WebServlet("/addProductServlet")
public class addProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stu
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String productId = request.getParameter("pid");
		String productName = request.getParameter("pname");
		String productQuantity = request.getParameter("pquantity");
		Double productPrice = Double.parseDouble(request.getParameter("pprice"));
		String productDescription = request.getParameter("pdescription");
		String productCategory = request.getParameter("category");
		
		try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://ec2-34-193-112-164.compute-1.amazonaws.com:5432/d7jdcs2gd3carr", "azxcuqwjjdmxwi", "5894ea67c1b0c0ade677dfa6ed46eccb3ec87b725b9321971cdbf7008674901a")) {
			
            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
            
            String sql = "insert into public.\"Product\" (?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, productId);
            pst.setString(2, productName);
            pst.setString(3, productQuantity);
            pst.setDouble(4, productPrice);
            pst.setString(5, productDescription);
            pst.setString(6, productCategory);
            int numRowsChanged = pst.executeUpdate();
            
            out.println(" Hello : ");
            
            
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
