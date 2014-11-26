package br.com.pattern.util;

import java.nio.file.Paths;

import br.com.pattern.conn.Configuration;
import br.com.pattern.conn.Connection;
import br.com.pattern.conn.ConnectionFactory;
import br.com.pattern.conn.FileConfiguration;

public class ConnectionUtil {
	private ConnectionUtil() {
		throw new UnsupportedOperationException("Classe utilitaria, não instanciavel.");
	}

	private static class Holder {
		private static final ConnectionFactory factory;
		static {
			FileConfiguration config = Configuration.build(FileConfiguration.class);
			config.setOutFolder(Paths.get("./db"));
			//MemoryConfiguration config = Configuration.build(MemoryConfiguration.class);
			factory = config.buildFactory();
		}
	}
	
	public static Connection getConnection() {
		return Holder.factory.getConnection();
	}
}
