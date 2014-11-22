package br.com.pattern.conn;

public abstract class Configuration {
	public static Configuration build(ConfigurationType type) {
		switch(type) {
			case FILE: return new FileConfiguration();
			case MEMORY: return new MemoryConfiguration();
		}
		return new MemoryConfiguration();
	}
	
	public abstract ConnectionFactory buildFactory();
}
