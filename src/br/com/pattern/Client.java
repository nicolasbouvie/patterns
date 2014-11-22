package br.com.pattern;

import java.io.IOException;

import com.bla.thirdpart.ThirdPartClass;

import br.com.pattern.conn.Connection;
import br.com.pattern.conn.Persistent;
import br.com.pattern.model.ThirdPartAdapter;
import br.com.pattern.model.PersistentClass;
import br.com.pattern.util.ConnectionUtil;

public class Client {
	public static void main(String[] args) throws IOException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			connection.save(new PersistentClass(1, "Teste"));
			PersistentClass persistentClass = connection.get(PersistentClass.class, 1);
			System.out.println(persistentClass);
			
			ThirdPartClass thirdPart = new ThirdPartClass("Blah");
			
			Persistent thirdPartPersistent = new ThirdPartAdapter<ThirdPartClass>(thirdPart);
			connection.save(thirdPartPersistent);
			System.out.println(getThirdPartObject(connection));
		}
	}

	@SuppressWarnings("unchecked")
	private static ThirdPartClass getThirdPartObject(Connection connection) {
		ThirdPartAdapter<ThirdPartClass> thirdPartClass = connection.get(ThirdPartAdapter.class, 1);
		return thirdPartClass.getThirdPart();
	}
}
