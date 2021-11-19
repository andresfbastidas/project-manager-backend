package co.edu.usbcali.projectmanager.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the link_attached database table.
 * 
 */
@Entity
@Table(name="link_attached")
@NamedQuery(name="LinkAttached.findAll", query="SELECT l FROM LinkAttached l")
public class LinkAttached implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="link_attached_seq" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="link_attached_seq")
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