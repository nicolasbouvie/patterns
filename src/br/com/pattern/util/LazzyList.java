package br.com.pattern.util;

import java.io.File;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import br.com.pattern.conn.Connection;

public class LazzyList<E extends Serializable> extends AbstractList<E> {
	private final Map<Integer, E> values = new HashMap<>();
	private final File[] files;
	private final Connection conn;
	private final Class<E> type;
	
	public LazzyList(Class<E> type, File[] files, Connection conn) {
		this.type = type;
		this.files = files;
		this.conn = conn;
	}
	
	@Override
	public int size() {
		return files.length;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			int idx = 0;

			@Override
			public boolean hasNext() {
				return files.length > idx;
			}

			@Override
			public E next() {
				File file = files[idx++];
				int serIdx = Integer.parseInt(file.getName().replace(".ser", ""));
				return get(serIdx);
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	@Override
	public E get(int index) {
		if (values.size() <= index || values.get(index) == null) {
			E el = conn.get(type, index);
			values.put(index, el);
		}
		
		return values.get(index);
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		File[] subFiles = Arrays.copyOfRange(files, fromIndex, toIndex);
		return new LazzyList<E>(type, subFiles, conn);
	}
}
