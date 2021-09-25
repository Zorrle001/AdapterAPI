package de.zorrle001.adapterapi.api.interfaces;

public abstract interface ListenerAdapter {
	
	public default String getName() {
		return this.getClass().getSimpleName();
	}
	
}
