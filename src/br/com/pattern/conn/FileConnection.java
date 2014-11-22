package br.com.pattern.conn;

import java.io.File;
import java.util.List;

public class FileConnection implements Connection {
	private File outFolder;

	public FileConnection(File outFolder) {
		this.outFolder = outFolder;
	}

	@Override
	public <T extends Persistent> T get(Class<T> type, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Persistent> void save(T object) {
		// TODO Auto-generated method stub
	}

	@Override
	public <T extends Persistent> List<T> getAll(Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

}
