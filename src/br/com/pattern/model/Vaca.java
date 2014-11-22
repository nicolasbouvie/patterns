package br.com.pattern.model;

import br.com.pattern.conn.Persistent;

public class Vaca implements Persistent {
	private long id;
	private String nome;
	
	public Vaca(long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
