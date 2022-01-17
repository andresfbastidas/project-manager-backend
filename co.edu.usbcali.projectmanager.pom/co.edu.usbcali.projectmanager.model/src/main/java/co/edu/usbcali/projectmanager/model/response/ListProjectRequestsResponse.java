package co.edu.usbcali.projectmanager.model.response;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;

import co.edu.usbcali.projectmanager.model.commons.PagedCustom;
import co.edu.usbcali.projectmanager.model.entities.ProjectRequest;

public class ListProjectRequestsResponse implements Serializable {

	private List<ProjectRequest> listProjectRequests;
	private Pageable pagable;
	private PagedCustom pagedCustom;

	public Pageable getPagable() {
		return pagable;
	}

	public void setPagable(Pageable pagable) {
		this.pagable = pagable;
	}

	public PagedCustom getPagedCustom() {
		return pagedCustom;
	}

	public void setPagedCustom(PagedCustom pagedCustom) {
		this.pagedCustom = pagedCustom;
	}

	public List<ProjectRequest> getListProjectRequests() {
		return listProjectRequests;
	}

	public void setListProjectRequests(List<ProjectRequest> listProjectRequests) {
		this.listProjectRequests = listProjectRequests;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 193729508237384498L;

}
