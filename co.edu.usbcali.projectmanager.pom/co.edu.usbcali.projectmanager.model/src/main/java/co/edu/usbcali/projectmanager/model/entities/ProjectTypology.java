package co.edu.usbcali.projectmanager.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the project_typology database table.
 * 
 */
@Entity
@Table(name="project_typology")
@NamedQuery(name="ProjectTypology.findAll", query="SELECT p FROM ProjectTypology p")
public class ProjectTypology implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="project_typology_seq" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="project_typology_seq")
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