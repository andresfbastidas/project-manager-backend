package co.edu.usbcali.projectmanager.model.request;

import java.io.Serializable;
import java.util.List;

import co.edu.usbcali.projectmanager.model.entities.ProjectRequest;

public class ApprovalDeclineRequest implements Serializable {

	private List<ProjectRequest> listProjectRequests;

	public List<ProjectRequest> getListProjectRequests() {
		return listProjectRequests;
	}

	public void setListProjectRequests(List<ProjectRequest> listProjectRequests) {
		this.listProjectRequests = listProjectRequests;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2427873937620705090L;

}
