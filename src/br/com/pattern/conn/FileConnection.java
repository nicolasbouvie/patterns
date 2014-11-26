package br.com.pattern.conn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.List;

import br.com.pattern.model.ThirdPartAdapter;
import br.com.pattern.util.LazzyList;

public class FileConnection implements Connection {
	private Path outFolder;

	public FileConnection(Path outFolder) {
		this.outFolder = outFolder;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Serializable> T get(Class<T> type, int id) {
		File sourceFile = getDir(type).resolve(id+".ser").toFile();
		if (Persistent.class.isAssignableFrom(type)) {
			return getPersistedObject(sourceFile);
		} else {
			return (T) ((ThirdPartAdapter<?>)getPersistedObject(sourceFile)).getThirdPart();
		}
	}

	@Override
	public <T extends Serializable> void save(T object) {
		Path dir;
		if (object instanceof ThirdPartAdapter<?>) {
			ThirdPartAdapter<?> adapter = (ThirdPartAdapter<?>) object;
			dir = getDir(adapter.getThirdPart().getClass());
		} else {
			dir = getDir(object.getClass());
		}
		if (!dir.toFile().isDirectory()) {
			dir.toFile().mkdirs();
		}
		File persistTarget = dir.resolve(object.hashCode() + ".ser").toFile();
		persist(object, persistTarget);
	}

	@Override
	public <T extends Serializable> List<T> getAll(Class<T> type) {
		return new LazzyList<T>(type, getDir(type).toFile().listFiles(), this);
	}

	@Override
	public void close() throws IOException {
		
	}

	private Path getDir(Class<?> type) {
		String path = type.getName().replaceAll("\\.", File.separator);
		return outFolder.resolve(path);
	}
	
	private <T extends Serializable> void persist(T obj, File target) {
		try (ObjectOutputStream outputStream = 
				new ObjectOutputStream(new FileOutputStream(target))) {
			outputStream.writeObject(obj);
		} catch (IOException e) {}
	}
	
	@SuppressWarnings("unchecked")
	private <T> T getPersistedObject(File source) {
		try (ObjectInputStream inputStream = 
				new ObjectInputStream(new FileInputStream(source))) {
			return (T) inputStream.readObject();
		} catch (IOException | ClassNotFoundException e) {}
		return null;
	}
}
