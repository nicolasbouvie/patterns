package br.com.pattern.conn;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MemoryConnection implements Connection {
	private static Map<Class<? extends Persistent>, Map<Long, Persistent>> objetos;
	
	static {
		objetos = new HashMap<Class<? extends Persistent>, Map<Long, Persistent>>();
	}
	
	@Override
	public <T extends Persistent> T get(Class<T> type, long id) {
		if (objetos.containsKey(type)) {
			Object obj = objetos.get(type).get(id);
			if (type.isInstance(obj)) {
				return type.cast(obj);
			}
		}
		return null;
	}

	@Override
	public <T extends Persistent> void save(T object) {
		if (!objetos.containsKey(object.getClass())) {
			objetos.put(object.getClass(), new HashMap<Long, Persistent>());
		}
		objetos.get(object.getClass()).put(object.getId(), object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Persistent> Collection<T> getAll(Class<T> type) {
		if (objetos.containsKey(type)) {
			return (Collection<T>) objetos.get(type).values();
		}
		return Collections.emptyList();
	}

	@Override
	public void close() throws IOException {
		
	}

}
