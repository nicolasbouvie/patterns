package br.com.pattern.conn;

import java.io.Closeable;
import java.io.Serializable;
import java.util.Collection;

public interface Connection extends Closeable {
	<T extends Serializable> T get(Class<T> type, int id);
	<T extends Serializable> void save(T object);
	<T extends Serializable> Collection<T> getAll(Class<T> type);
}
