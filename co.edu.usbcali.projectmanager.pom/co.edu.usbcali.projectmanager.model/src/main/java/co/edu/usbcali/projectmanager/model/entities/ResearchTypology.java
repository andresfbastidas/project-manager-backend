package co.edu.usbcali.projectmanager.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Research_Typology" database table.
 * 
 */
@Entity
@Table(name="Research_Typology")
@NamedQuery(name="Research_Typology.findAll", query="SELECT r FROM Research_Typology r")
public class ResearchTypology implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROJECTRESEARCHTYPOLOGYID_GENERATOR", sequenceName="RESEARCH_TYPOLOGY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROJECTRESEARCHTYPOLOGYID_GENERATOR")
	@Column(name="project_research_typology_id")
	private Long projectResearchTypologyId;

	@Column(name="product_type")
	private String productType;

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

	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getTypologyDescription() {
		return this.typologyDescription;
	}

	public void setTypologyDescription(String typologyDescription) {
		this.typologyDescription = typologyDescription;
	}

}