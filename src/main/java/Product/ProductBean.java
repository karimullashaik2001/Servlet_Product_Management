package Product;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProductBean implements Serializable
{
	private String pcode,pname;
	private float pprice;
	private int qty;
	public ProductBean()
	{
		
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public float getPprice() {
		return pprice;
	}
	public void setPprice(float pprice) {
		this.pprice = pprice;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
}
