package Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDAO 
{
	public int k=0;
	public int productdao(ProductBean pb)
	{
		try {
			Connection con=DBConnection.getcon();
			PreparedStatement pstmt=con.prepareStatement("insert into product values(?,?,?,?)");
			pstmt.setString(1,pb.getPcode());
			pstmt.setString(2,pb.getPname());
			pstmt.setFloat(3,pb.getPprice());
			pstmt.setInt(4,pb.getQty());
			k=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;
	}
}
