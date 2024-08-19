package Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowProductServlet
 */
public class ShowProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		try {
			Connection con=DBConnection.getcon();
			PreparedStatement pstmt=con.prepareStatement("select * from product");
			PrintWriter pw=response.getWriter();
			response.setContentType("text/html");
			ResultSet rs=pstmt.executeQuery();
			ResultSetMetaData rsm=rs.getMetaData();
			int n=rsm.getColumnCount();
			pw.println("<html><body ><table border-collapse:collapsed><caption>Product Details</caption>");
			pw.println("<tr>");
			for(int i=1;i<=n;i++)
			{
				pw.println("<th>"+rsm.getColumnName(i)+"</th>");
			}
			pw.println("</tr>");
			while(rs.next())
			{
				pw.println("<tr>");
				for(int i=1;i<=n;i++)
				{
					pw.println("<td>"+rs.getString(i)+"</td>");
				}
				pw.println("</tr>");
			}
			pw.println("</table></body></html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	RequestDispatcher rd=request.getRequestDispatcher("product.html");
	rd.include(request, response);
}
}

