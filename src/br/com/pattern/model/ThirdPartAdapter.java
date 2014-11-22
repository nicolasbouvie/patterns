package br.com.pattern.model;

import java.io.Serializable;

import br.com.pattern.conn.Persistent;

public class ThirdPartAdapter<V extends Serializable> implements Persistent {
	private static final long serialVersionUID = -5129229461373351995L;
	private V thirdPart;
	
	public ThirdPartAdapter(V thirdPart) {
		this.thirdPart = thirdPart;
	}
	
	@Override
	public long getId() {
		return 1;
	}

	public V getThirdPart() {
		return thirdPart;
	}
}
