package co.edu.usbcali.projectmanager.model.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ProjectsListDTO implements Serializable {

	@Id
	@Column(name = "project_id")
	private Long projectId;

	@Column(name = "date_from")
	private Date dateFrom;

	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "date_until")
	private Date dateUntil;

	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "general_objetive")
	private String generalObjetive;

	@Column(name = "justification")
	private String justification;

	@Column(name = "project_methology")
	private String projectMethology;

	@Column(name = "project_summary")
	private String projectSummary;

	@Column(name = "project_title")
	private String projectTitle;

	@Column(name = "specific_objetive")
	private String specificObjetive;

	@Column(name = "project_director")
	private String projectDirector;

	@Column(name = "typology_description")
	private String typologyDescription;

	@Column(name = "create_by")
	private String createBy;

	@Column(name = "state_name")
	private String stateName;

	@Column(name = "deliverys")
	private String deliverys;

	public ProjectsListDTO(Long projectId, Date dateFrom, Date dateUntil, String generalObjetive, String justification,
			String projectMethology, String projectSummary, String projectTitle, String specificObjetive,
			String projectDirector, String typologyDescription, String createBy, String stateName, String deliverys) {
		super();
		this.projectId = projectId;
		this.dateFrom = dateFrom;
		this.dateUntil = dateUntil;
		this.generalObjetive = generalObjetive;
		this.justification = justification;
		this.projectMethology = projectMethology;
		this.projectSummary = projectSummary;
		this.projectTitle = projectTitle;
		this.specificObjetive = specificObjetive;
		this.projectDirector = projectDirector;
		this.typologyDescription = typologyDescription;
		this.createBy = createBy;
		this.stateName = stateName;
		this.deliverys = deliverys;
	}

	public ProjectsListDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getSpecificObjetive() {
		return specificObjetive;
	}

	public void setSpecificObjetive(String specificObjetive) {
		this.specificObjetive = specificObjetive;
	}

	public String getProjectDirector() {
		return projectDirector;
	}

	public void setProjectDirector(String projectDirector) {
		this.projectDirector = projectDirector;
	}

	public String getTypologyDescription() {
		return typologyDescription;
	}

	public void setTypologyDescription(String typologyDescription) {
		this.typologyDescription = typologyDescription;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getDeliverys() {
		return deliverys;
	}

	public void setDeliverys(String deliverys) {
		this.deliverys = deliverys;
	}

	private static final long serialVersionUID = 1L;

}
