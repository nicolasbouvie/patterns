package br.com.pattern.conn;

import java.io.Serializable;

public abstract class Persistent implements Serializable {
	private static final long serialVersionUID = -6849460710173876921L;
	private int id;

	public Persistent(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		return id;
	}
}
