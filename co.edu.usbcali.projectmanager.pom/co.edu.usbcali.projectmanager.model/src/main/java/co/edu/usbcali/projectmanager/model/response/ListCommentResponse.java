package co.edu.usbcali.projectmanager.model.response;

import java.io.Serializable;
import java.util.List;

import co.edu.usbcali.projectmanager.model.entities.Comment;

public class ListCommentResponse implements Serializable {

	private List<Comment> listComments;
	private int currentPage;
	private Long totalElements;
	private int totalPages;

	public List<Comment> getListComments() {
		return listComments;
	}

	public void setListComments(List<Comment> listComments) {
		this.listComments = listComments;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public Long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
