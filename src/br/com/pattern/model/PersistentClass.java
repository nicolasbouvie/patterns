package br.com.pattern.model;

import br.com.pattern.conn.Persistent;

public class PersistentClass implements Persistent {
	private static final long serialVersionUID = 4584297383048231280L;

	private long id;
	private String name;
	
	public PersistentClass(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
