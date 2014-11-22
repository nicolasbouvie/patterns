package br.com.pattern.conn;

public class MemoryConfiguration extends Configuration {

	//metodos para configuracao do memory
	
	@Override
	public ConnectionFactory buildFactory() {
		return new MemoryConnectionFactory();
	}
}
