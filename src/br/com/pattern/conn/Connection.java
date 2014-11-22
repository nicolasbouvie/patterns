package br.com.pattern.conn;

import java.util.Collection;

public interface Connection {
	<T extends Persistent> T get(Class<T> type, long id);
	<T extends Persistent> void save(T object);
	<T extends Persistent> Collection<T> getAll(Class<T> type);
}
