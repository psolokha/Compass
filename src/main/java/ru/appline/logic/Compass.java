package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

public class Compass implements Serializable {
	
	@Getter @Setter
	private Map<Integer, String> compass = new HashMap();
	
	public Compass() {
		super();
	}
	
	public void setDegree(int degree, String side) {
		compass.put(degree, side);
	}
	
	public String getDegree(int degree) {
		return compass.containsKey(degree) ? compass.get(degree) : "wrong degree value";
	}
}
