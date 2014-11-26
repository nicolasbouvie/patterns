package br.com.pattern.model;

import java.io.Serializable;

import br.com.pattern.conn.Persistent;

public class ThirdPartAdapter<V extends Serializable> extends Persistent {
	private static final long serialVersionUID = -5129229461373351995L;
	private V thirdPart;
	
	public ThirdPartAdapter(V thirdPart) {
		super(1);
		this.thirdPart = thirdPart;
	}

	public V getThirdPart() {
		return thirdPart;
	}
}
