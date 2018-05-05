package com.rajivraghu.hibernate.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
/*@DiscriminatorValue("Car")*/
public class FourWheeler extends Vehicle {
	
	
	private String forWheelSteering;

	public String getForWheelSteering() {
		return forWheelSteering;
	}

	public void setForWheelSteering(String forWheelSteering) {
		this.forWheelSteering = forWheelSteering;
	}



}
