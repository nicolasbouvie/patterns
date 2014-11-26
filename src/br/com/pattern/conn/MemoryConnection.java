package br.com.pattern.conn;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import br.com.pattern.model.ThirdPartAdapter;

public class MemoryConnection implements Connection {
	private static Map<Class<?>, Map<Integer, Persistent>> objetos = new HashMap<>();
	
	@Override
	public <T extends Serializable> T get(Class<T> type, int id) {
		if (objetos.containsKey(type)) {
			Object obj = objetos.get(type).get(id);
			if (!Persistent.class.isAssignableFrom(type)) {
				ThirdPartAdapter<?> adapter = (ThirdPartAdapter<?>) obj;
				return type.cast(adapter.getThirdPart());
			}
			return type.cast(obj);
		}
		return null;
	}

	@Override
	public <T extends Serializable> void save(T object) {
		Persistent pers;
		if (!Persistent.class.isAssignableFrom(object.getClass())) {
			pers = new ThirdPartAdapter<Serializable>(object);
		} else {
			pers = (Persistent) object;
		}
		if (!objetos.containsKey(object.getClass())) {
			objetos.put(object.getClass(), new HashMap<Integer, Persistent>());
		}
		objetos.get(object.getClass()).put(pers.getId(), pers);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Serializable> Collection<T> getAll(Class<T> type) {
		if (objetos.containsKey(type)) {
			return (Collection<T>) objetos.get(type).values();
		}
		return Collections.emptyList();
	}

	@Override
	public void close() throws IOException {
		
	}

}
