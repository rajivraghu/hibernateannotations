package com.rajivraghu.hibernate.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



@Entity
@Table(name="PLAYER")
public class Player {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ID_SEQ")
	@SequenceGenerator(name="ID_SEQ", sequenceName="ID_SEQ")
	@Column(name="PLAYER_ID")
	Integer playerId;
	
	@Column(name="PLAYER_NAME")
	String playerName;
	@Column(name="PLAYER_TYPE")
	String playerType;
	@Column(name="TEAM_ID")
	Integer teamId;

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerType() {
		return playerType;
	}

	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	
	
	
	

}
