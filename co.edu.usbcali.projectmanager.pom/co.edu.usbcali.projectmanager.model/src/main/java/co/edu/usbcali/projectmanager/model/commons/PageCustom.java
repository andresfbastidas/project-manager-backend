package co.edu.usbcali.projectmanager.model.commons;

import java.io.Serializable;

import org.springframework.data.domain.Sort;

public class PageCustom implements Serializable {

	private static final long serialVersionUID = 1L;
	private Sort sort;
	private long offset;
	private int pageSize;
	private int pageNumber;
	private Boolean paged;
	private Boolean unpaged;
	private Boolean first;
	private Boolean last;
	private int totalPages;

	public PageCustom() {
		super();
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	public long getOffset() {
		return offset;
	}

	public void setOffset(long offset) {
		this.offset = offset;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Boolean getPaged() {
		return paged;
	}

	public void setPaged(Boolean paged) {
		this.paged = paged;
	}

	public Boolean getUnpaged() {
		return unpaged;
	}

	public void setUnpaged(Boolean unpaged) {
		this.unpaged = unpaged;
	}

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
}
