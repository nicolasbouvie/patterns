package br.com.pattern.util;

import br.com.pattern.conn.Configuration;
import br.com.pattern.conn.ConfigurationType;
import br.com.pattern.conn.Connection;
import br.com.pattern.conn.ConnectionFactory;

public class ConnectionUtil {
	private ConnectionUtil() {
		throw new UnsupportedOperationException("Classe utilitaria, não instanciavel.");
	}

	private static class Holder {
		private static final ConnectionFactory factory;
		static {
			Configuration config = 
					Configuration.build(ConfigurationType.MEMORY);
			factory = config.buildFactory();
		}
	}
	
	public static Connection getConnection() {
		return Holder.factory.getConnection();
	}
}
