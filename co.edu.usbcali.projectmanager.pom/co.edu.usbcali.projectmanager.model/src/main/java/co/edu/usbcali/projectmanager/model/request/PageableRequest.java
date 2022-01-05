package co.edu.usbcali.projectmanager.model.request;

import java.io.Serializable;

public class PageableRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private int numPage;
	private int numReg;
	public PageableRequest() {
		super();
	}
	
	public int getNumPage() {
		return numPage;
	}
	public void setNumPage(int numPage) {
		this.numPage = numPage;
	}
	public int getNumReg() {
		return numReg;
	}
	public void setNumReg(int numReg) {
		this.numReg = numReg;
	}
}
