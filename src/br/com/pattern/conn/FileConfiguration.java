package br.com.pattern.conn;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileConfiguration extends Configuration {
	private Path outFolder;
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
		File out = outFolder.toFile();
		if (!out.exists() && !out.mkdirs()) {
			throw new IllegalStateException("Não foi possível criar OutFolder.");
		}
		if (!out.isDirectory() || !out.canRead() || !out.canWrite()) {
			throw new IllegalStateException("OutFolder não é um diretório válido.");
		}
	}

	public FileConfiguration setOutFolder(Path outFolder) {
		if (outFolder == null) {
			outFolder = Paths.get("./db");
		}
		
		this.outFolder = outFolder.toAbsolutePath().normalize();
		return this;
	}
}
