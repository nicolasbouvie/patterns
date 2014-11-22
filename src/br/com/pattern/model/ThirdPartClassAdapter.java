package br.com.pattern.model;

import com.bla.thirdpart.ThirdPartClass;

import br.com.pattern.conn.Persistent;

public class ThirdPartClassAdapter implements Persistent {
	private ThirdPartClass thirdPart;
	
	public ThirdPartClassAdapter(ThirdPartClass thirdPart) {
		this.thirdPart = thirdPart;
	}
	
	@Override
	public long getId() {
		return 0;
	}

	public ThirdPartClass getThirdPart() {
		return thirdPart;
	}
}
