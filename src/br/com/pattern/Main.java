package br.com.pattern;

import com.bla.thirdpart.ThirdPartClass;

import br.com.pattern.conn.Connection;
import br.com.pattern.conn.Persistent;
import br.com.pattern.model.ThirdPartClassAdapter;
import br.com.pattern.model.Vaca;
import br.com.pattern.util.ConnectionUtil;

public class Main {
	public static void main(String[] args) {		
		Connection connection = ConnectionUtil.getConnection();
		
		connection.save(new Vaca(1, "Teste"));
		Vaca vaca = connection.get(Vaca.class, 1);
		System.out.println(vaca);
		
		ThirdPartClass thirdPart = new ThirdPartClass("Blah");
		
		Persistent thirdPartPersistent = new ThirdPartClassAdapter(thirdPart);
		connection.save(thirdPartPersistent);
	}
}
