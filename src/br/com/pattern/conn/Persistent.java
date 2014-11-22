package br.com.pattern.conn;

import java.io.Serializable;

public interface Persistent extends Serializable {
	long getId();
}
