package br.com.pattern.conn;

import java.nio.file.Path;

public class FileConnectionFactory extends ConnectionFactory {
	private Path outFolder;

	public FileConnectionFactory(Path outFolder) {
		this.outFolder = outFolder;
	}

	@Override
	public Connection getConnection() {
		return new FileConnection(outFolder);
	}
}
