package br.com.pattern.conn;

public class MemoryConnectionFactory extends ConnectionFactory {
	
	@Override
	public Connection getConnection() {
		return new MemoryConnection();
	}
}
