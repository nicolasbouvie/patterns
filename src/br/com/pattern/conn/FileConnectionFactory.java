package br.com.pattern.conn;

import java.io.File;

public class FileConnectionFactory extends ConnectionFactory {
	private File outFolder;

	public FileConnectionFactory(File outFolder) {
		this.outFolder = outFolder;
	}

	@Override
	public Connection getConnection() {
		return new FileConnection(outFolder);
	}
}
