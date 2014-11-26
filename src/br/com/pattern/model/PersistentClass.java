package br.com.pattern.model;

import br.com.pattern.conn.Persistent;

public class PersistentClass extends Persistent {
	private static final long serialVersionUID = 4584297383048231280L;

	private String name;
	
	public PersistentClass(int id, String name) {
		super(id);
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
