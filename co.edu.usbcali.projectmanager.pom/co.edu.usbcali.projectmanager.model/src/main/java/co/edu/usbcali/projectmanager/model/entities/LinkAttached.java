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
 * The persistent class for the "Link_Attached" database table.
 * 
 */
@Entity
@Table(name="Link_Attached")
@NamedQuery(name="Link_Attached.findAll", query="SELECT l FROM Link_Attached l")
public class LinkAttached implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LINKATTACHEDID_GENERATOR", sequenceName="LINK_ATTACHED_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LINKATTACHEDID_GENERATOR")
	@Column(name="link_attached_id")
	private Long linkAttachedId;

	@Column(name="link_attached")
	private String linkAttached;

	//bi-directional many-to-one association to Activity
	@ManyToOne
	@JoinColumn(name="activity_id")
	private Activity activity;

	public LinkAttached() {
	}

	public Long getLinkAttachedId() {
		return this.linkAttachedId;
	}

	public void setLinkAttachedId(Long linkAttachedId) {
		this.linkAttachedId = linkAttachedId;
	}

	public String getLinkAttached() {
		return this.linkAttached;
	}

	public void setLinkAttached(String linkAttached) {
		this.linkAttached = linkAttached;
	}

	public Activity getActivity() {
		return this.activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

}