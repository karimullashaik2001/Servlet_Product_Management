package Product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddProductServlet
 */
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
public ProductBean pb=null;
    /**
     * Default constructor. 
     */
    public AddProductServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		pb=new ProductBean();
		pb.setPcode(request.getParameter("pcode"));
		pb.setPname(request.getParameter("pname"));
		pb.setPprice(Float.parseFloat(request.getParameter("pprice")));
		pb.setQty(Integer.parseInt(request.getParameter("qty")));
		int k=new ProductDAO().productdao(pb);
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		if(k>0)
		{
			pw.println("product added successfully... <br>");
			RequestDispatcher rd=request.getRequestDispatcher("product.html");
			rd.include(request, response);
		}
	}

}
