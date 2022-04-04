package co.edu.usbcali.projectmanager.model.commons;

import java.io.Serializable;

public class PageSetting implements Serializable{
	
	
	private int numPage;
	private int numReg;
	
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

	private static final long serialVersionUID = 4056424156162602885L;
}