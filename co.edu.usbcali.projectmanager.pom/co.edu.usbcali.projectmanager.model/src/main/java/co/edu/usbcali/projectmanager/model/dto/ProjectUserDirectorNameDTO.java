package co.edu.usbcali.projectmanager.model.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.edu.usbcali.projectmanager.model.entities.State;

@Entity
public class ProjectUserDirectorNameDTO implements Serializable {

	@Id
	@SequenceGenerator(name = "PROJECT_PROJECTID_GENERATOR", sequenceName = "PROJECT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROJECT_PROJECTID_GENERATOR")
	@Column(name = "project_id")
	private Long projectId;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_from")
	private Date dateFrom;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_until")
	private Date dateUntil;

	@Column(name = "general_objetive")
	private String generalObjetive;

	@Column(name = "justification")
	private String justification;

	@Column(name = "project_methology")
	private String projectMethology;

	@Column(name = "project_research_typology_id")
	private Long projectResearchTypologyId;

	@Column(name = "project_summary")
	private String projectSummary;

	@Column(name = "project_title")
	private String projectTitle;

	@Column(name = "specific_objetive")
	private String specificObjetive;

	@Column(name = "project_director")
	private String projectDirector;

	@Column(name = "directorname")
	private String directorName;

	@Column(name = "create_by_names")
	private String createByNames;

	@Column(name = "create_by")
	private String createBy;

	@Column(name = "users")
	private String users;

	@ManyToOne
	@JoinColumn(name = "state_id")
	private State state;

	public ProjectUserDirectorNameDTO(Long projectId, Date dateFrom, Date dateUntil, String projectTitle,
			String generalObjetive, String projectSummary, String projectMethology, String specificObjetive,
			String justification, Long projectResearchTypologyId, State state, String projectDirector,
			String directorName, String createBy, String users, String createByNames) {
		super();
		this.projectId = projectId;
		this.dateFrom = dateFrom;
		this.dateUntil = dateUntil;
		this.generalObjetive = generalObjetive;
		this.justification = justification;
		this.projectMethology = projectMethology;
		this.projectResearchTypologyId = projectResearchTypologyId;
		this.projectSummary = projectSummary;
		this.projectTitle = projectTitle;
		this.specificObjetive = specificObjetive;
		this.projectDirector = projectDirector;
		this.directorName = directorName;
		this.state = state;
		this.createBy = createBy;
		this.users = users;
		this.createByNames = createByNames;
	}

	public ProjectUserDirectorNameDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCreateByNames() {
		return createByNames;
	}

	public void setCreateByNames(String createByNames) {
		this.createByNames = createByNames;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
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

	public Long getProjectResearchTypologyId() {
		return projectResearchTypologyId;
	}

	public void setProjectResearchTypologyId(Long projectResearchTypologyId) {
		this.projectResearchTypologyId = projectResearchTypologyId;
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

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	private static final long serialVersionUID = 5576104201635957362L;

}
