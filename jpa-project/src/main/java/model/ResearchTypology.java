package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the research_typology database table.
 * 
 */
@Entity
@Table(name="research_typology")
@NamedQuery(name="ResearchTypology.findAll", query="SELECT r FROM ResearchTypology r")
public class ResearchTypology implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RESEARCH_TYPOLOGY_PROJECTRESEARCHTYPOLOGYID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RESEARCH_TYPOLOGY_PROJECTRESEARCHTYPOLOGYID_GENERATOR")
	@Column(name="project_research_typology_id")
	private Long projectResearchTypologyId;

	@Column(name="typology_description")
	private String typologyDescription;

	public ResearchTypology() {
	}

	public Long getProjectResearchTypologyId() {
		return this.projectResearchTypologyId;
	}

	public void setProjectResearchTypologyId(Long projectResearchTypologyId) {
		this.projectResearchTypologyId = projectResearchTypologyId;
	}

	public String getTypologyDescription() {
		return this.typologyDescription;
	}

	public void setTypologyDescription(String typologyDescription) {
		this.typologyDescription = typologyDescription;
	}

}