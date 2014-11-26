package br.com.pattern.conn;

public abstract class Configuration {
	public static <T extends Configuration> T build(Class<T> type) {
		if (type == null) {
			throw new IllegalArgumentException("Parâmetro type é obrigatório!");
		}
		try {
			return type.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new IllegalArgumentException("Classe deve definir um construtor público default.");
		}
	}
	
	public abstract ConnectionFactory buildFactory();
}
