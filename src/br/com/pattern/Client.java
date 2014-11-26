package br.com.pattern;

import java.io.IOException;
import java.util.Collection;

import br.com.pattern.conn.Connection;
import br.com.pattern.model.PersistentClass;
import br.com.pattern.util.ConnectionUtil;

import com.bla.thirdpart.ThirdPartClass;

public class Client {
	public static void main(String[] args) throws IOException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			connection.save(new PersistentClass(1, "Teste1"));
			connection.save(new PersistentClass(2, "Teste2"));
			connection.save(new PersistentClass(3, "Teste3"));

			PersistentClass persistentClass = connection.get(PersistentClass.class, 2);
			System.out.println(persistentClass);
			
			connection.save(new ThirdPartClass("Blah"));
			ThirdPartClass thirdPartClass = connection.get(ThirdPartClass.class, 1);
			System.out.println(thirdPartClass);
			
			Collection<PersistentClass> all = connection.getAll(PersistentClass.class);
			for (PersistentClass p : all) {
				System.out.println(p);
			}
		}
	}
}
