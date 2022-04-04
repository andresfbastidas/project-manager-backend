package co.edu.usbcali.projectmanager.model.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ProjectRequestInfoDTO implements Serializable {

	@Id
	@Column(name = "project_request_id")
	private Long projectRequestId;

	@Column(name = "project_id")
	private Long projectId;

	@Column(name = "date_from")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dateFrom;

	@Column(name = "date_until")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dateUntil;

	@Column(name = "general_objetive")
	private String generalObjetive;

	@Column(name = "specific_objetive")
	private String specificObjetive;

	@Column(name = "project_title")
	private String projectTitle;

	@Column(name = "justification")
	private String justification;

	@Column(name = "project_methology")
	private String projectMethology;

	@Column(name = "project_summary")
	private String projectSummary;

	@Column(name = "details")
	private String details;

	@Column(name = "typology_description")
	private String typologyDescription;

	@Column(name = "deliverys")
	private String deliverys;

	@Column(name = "create_by")
	private String createBy;

	public ProjectRequestInfoDTO(Long projectRequestId, Long projectId, Date dateFrom, Date dateUntil,
			String generalObjetive, String specificObjetive, String projectTitle, String justification,
			String projectMethology, String projectSummary, String details, String typologyDescription,
			String deliverys, String createBy) {
		super();
		this.projectRequestId = projectRequestId;
		this.projectId = projectId;
		this.dateFrom = dateFrom;
		this.dateUntil = dateUntil;
		this.generalObjetive = generalObjetive;
		this.specificObjetive = specificObjetive;
		this.projectTitle = projectTitle;
		this.justification = justification;
		this.projectMethology = projectMethology;
		this.projectSummary = projectSummary;
		this.details = details;
		this.typologyDescription = typologyDescription;
		this.deliverys = deliverys;
		this.createBy = createBy;
	}

	public ProjectRequestInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getProjectRequestId() {
		return projectRequestId;
	}

	public void setProjectRequestId(Long projectRequestId) {
		this.projectRequestId = projectRequestId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateUntil() {
		return dateUntil;
	}

	public void setDateUntil(Date dateUntil) {
		this.dateUntil = dateUntil;
	}

	public String getGeneralObjetive() {
		return generalObjetive;
	}

	public void setGeneralObjetive(String generalObjetive) {
		this.generalObjetive = generalObjetive;
	}

	public String getSpecificObjetive() {
		return specificObjetive;
	}

	public void setSpecificObjetive(String specificObjetive) {
		this.specificObjetive = specificObjetive;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public String getProjectMethology() {
		return projectMethology;
	}

	public void setProjectMethology(String projectMethology) {
		this.projectMethology = projectMethology;
	}

	public String getProjectSummary() {
		return projectSummary;
	}

	public void setProjectSummary(String projectSummary) {
		this.projectSummary = projectSummary;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getTypologyDescription() {
		return typologyDescription;
	}

	public void setTypologyDescription(String typologyDescription) {
		this.typologyDescription = typologyDescription;
	}

	public String getDeliverys() {
		return deliverys;
	}

	public void setDeliverys(String deliverys) {
		this.deliverys = deliverys;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3139074145613596071L;

}
