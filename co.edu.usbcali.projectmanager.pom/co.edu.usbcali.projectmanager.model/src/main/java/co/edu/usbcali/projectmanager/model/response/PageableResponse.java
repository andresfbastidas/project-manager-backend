package co.edu.usbcali.projectmanager.model.response;

import java.io.Serializable;
import java.util.List;

import co.edu.usbcali.projectmanager.model.commons.PageCustom;

public class PageableResponse <T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<T> records;
	private PageCustom pageCustom;
	
	public PageableResponse() {
		super();
	}
	
	public List<T> getRecords() {
		return records;
	}
	public void setRecords(List<T> records) {
		this.records = records;
	}
	public PageCustom getPageCustom() {
		return pageCustom;
	}
	public void setPageCustom(PageCustom pageCustom) {
		this.pageCustom = pageCustom;
	}
}
