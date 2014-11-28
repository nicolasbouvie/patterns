package br.com.pattern.conn;

public class MemoryConfiguration extends Configuration {

	public MemoryConfiguration setMaxRegistries(int max) {
		return this;
	}
	
	@Override
	public ConnectionFactory buildFactory() {
		return new MemoryConnectionFactory();
	}
}
