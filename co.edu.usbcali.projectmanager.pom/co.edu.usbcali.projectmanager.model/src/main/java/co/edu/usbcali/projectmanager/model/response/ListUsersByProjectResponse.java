package co.edu.usbcali.projectmanager.model.response;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;

import co.edu.usbcali.projectmanager.model.commons.PagedCustom;
import co.edu.usbcali.projectmanager.model.dto.UsersByProjectDTO;

public class ListUsersByProjectResponse<T> implements Serializable {

	private List<UsersByProjectDTO> listUsers;
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

	public List<UsersByProjectDTO> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<UsersByProjectDTO> listUsers) {
		this.listUsers = listUsers;
	}

	private static final long serialVersionUID = 3470587081880126786L;

}
