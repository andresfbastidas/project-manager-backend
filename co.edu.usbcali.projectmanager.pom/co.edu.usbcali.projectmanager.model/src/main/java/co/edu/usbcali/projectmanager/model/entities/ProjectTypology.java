package co.edu.usbcali.projectmanager.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the "Project_Typology" database table.
 * 
 */
@Entity
@Table(name="Project_Typology")
@NamedQuery(name="ProjectTypology.findAll", query="SELECT p FROM ProjectTypology p")
public class ProjectTypology implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROJECTTYPOLOGYID_GENERATOR", sequenceName="PROJECT_TYPOLOGY_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROJECTTYPOLOGYID_GENERATOR")
	@Column(name="project_typology_id")
	private Long projectTypologyId;

	@Column(name="project_research_typology_id")
	private Long projectResearchTypologyId;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;

	public ProjectTypology() {
	}

	public Long getProjectTypologyId() {
		return this.projectTypologyId;
	}

	public void setProjectTypologyId(Long projectTypologyId) {
		this.projectTypologyId = projectTypologyId;
	}

	public Long getProjectResearchTypologyId() {
		return this.projectResearchTypologyId;
	}

	public void setProjectResearchTypologyId(Long projectResearchTypologyId) {
		this.projectResearchTypologyId = projectResearchTypologyId;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}