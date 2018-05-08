package com.rajivraghu.hibernate.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER_TERRITORY_MAPPING")
public class UserTerritoryMapping  {

	@EmbeddedId
	private UserTerritoryMappingPK userTerritoryMappingPK;

	public UserTerritoryMappingPK getUserTerritoryMappingPK() {
		return userTerritoryMappingPK;
	}

	public void setUserTerritoryMappingPK(UserTerritoryMappingPK userTerritoryMappingPK) {
		this.userTerritoryMappingPK = userTerritoryMappingPK;
	}

}