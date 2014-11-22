package com.bla.thirdpart;

import java.io.Serializable;

public final class ThirdPartClass implements Serializable {
	private static final long serialVersionUID = -782391517974315989L;
	private String name;

	public ThirdPartClass(){}
	
	public ThirdPartClass(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
