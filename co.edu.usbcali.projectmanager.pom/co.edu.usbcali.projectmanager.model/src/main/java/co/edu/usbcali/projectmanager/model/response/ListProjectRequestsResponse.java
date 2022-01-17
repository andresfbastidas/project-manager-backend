package co.edu.usbcali.projectmanager.model.response;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;

import co.edu.usbcali.projectmanager.model.commons.PagedCustom;
import co.edu.usbcali.projectmanager.model.dto.ProjectRequestDTO;

public class ListProjectRequestsResponse implements Serializable {

	private List<ProjectRequestDTO> listProjectRequests;
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

	public List<ProjectRequestDTO> getListProjectRequests() {
		return listProjectRequests;
	}

	public void setListProjectRequests(List<ProjectRequestDTO> listProjectRequests) {
		this.listProjectRequests = listProjectRequests;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 193729508237384498L;

}
