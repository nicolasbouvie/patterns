package br.com.pattern.conn;

import java.io.File;

public class FileConfiguration extends Configuration {
	private File outFolder;
	//metodos para configuracao do fileConnection
	
	@Override
	public ConnectionFactory buildFactory() {
		verifyOutFolder();
		return new FileConnectionFactory(outFolder);
	}
	
	private void verifyOutFolder() {
		if (outFolder == null) {
			throw new IllegalStateException("OutFolder não foi setada.");
		}
		if (!outFolder.exists() && !outFolder.mkdirs()) {
			throw new IllegalStateException("Não foi possível criar OutFolder.");
		}
		if (!outFolder.isDirectory() || !outFolder.canRead() || !outFolder.canWrite()) {
			throw new IllegalStateException("OutFolder não é um diretório válido.");
		}
	}

	public FileConfiguration setOutFolder(File outFolder) {
		this.outFolder = outFolder;
		return this;
	}
}
