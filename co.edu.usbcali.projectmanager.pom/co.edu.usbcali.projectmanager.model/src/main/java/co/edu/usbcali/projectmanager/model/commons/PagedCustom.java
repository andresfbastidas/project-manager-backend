package co.edu.usbcali.projectmanager.model.commons;

import java.io.Serializable;

public class PagedCustom implements Serializable {

	private int totalPages;
	private Boolean first;
	private Boolean last;
	private int number;

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public Boolean getFirst() {
		return first;
	}

	public void setFirst(Boolean first) {
		this.first = first;
	}

	public Boolean getLast() {
		return last;
	}

	public void setLast(Boolean last) {
		this.last = last;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	private static final long serialVersionUID = -2335141952323217526L;
}