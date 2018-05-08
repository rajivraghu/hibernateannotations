package com.rajivraghu.hibernate.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Territory")
public class Territory implements Serializable {

	private static final long serialVersionUID = -6554803030914707438L;

	@Column(name = "TERRITORY_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BUSINESS_UNIT_SEQ")
    @SequenceGenerator(name = "BUSINESS_UNIT_SEQ", sequenceName = "BUSINESS_UNIT_SEQ", allocationSize = 1)
    private Integer territoryId;

	@Column(name = "TERRITORY_NAME")
    private String territoryName;

	@Column(name = "COMMUNITY_ID")
    private Integer communityId;
	
	
	@Column(name="PARENT_BU_ID")
	private Integer parentBuId;
	
	@Column(name = "TERRITORY_EXT_ID")
    private String territoryExtId;
	  
	

	public Integer getTerritoryId() {
		return territoryId;
	}

	public void setTerritoryId(Integer territoryId) {
		this.territoryId = territoryId;
	}

	public String getTerritoryName() {
		return territoryName;
	}

	public void setTerritoryName(String territoryName) {
		this.territoryName = territoryName;
	}

	public Integer getCommunityId() {
		return communityId;
	}

	public void setCommunityId(Integer communityId) {
		this.communityId = communityId;
	}

	

	public Integer getParentBuId() {
		return parentBuId;
	}

	public void setParentBuId(Integer parentBuId) {
		this.parentBuId = parentBuId;
	}

	public String getTerritoryExtId() {
		return territoryExtId;
	}

	public void setTerritoryExtId(String territoryExtId) {
		this.territoryExtId = territoryExtId;
	}
	
	
	
	
}
