package com.rajivraghu.hibernate.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
/*@DiscriminatorValue("Bike")*/
public class TwoWheeler extends Vehicle {
	
	
	private String twoWheelSteering;

	public String getTwoWheelSteering() {
		return twoWheelSteering;
	}

	public void setTwoWheelSteering(String twoWheelSteering) {
		this.twoWheelSteering = twoWheelSteering;
	}
	
	
	

}
