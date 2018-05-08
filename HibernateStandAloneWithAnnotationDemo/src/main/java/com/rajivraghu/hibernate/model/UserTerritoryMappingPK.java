package com.rajivraghu.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserTerritoryMappingPK implements Serializable {

	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "TERRITORY_ID")
	private String territoryId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTerritoryId() {
		return territoryId;
	}

	public void setTerritoryId(String territoryId) {
		this.territoryId = territoryId;
	}

}
