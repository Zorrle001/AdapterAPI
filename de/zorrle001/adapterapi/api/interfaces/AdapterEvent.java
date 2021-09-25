package de.zorrle001.adapterapi.api.interfaces;

public abstract interface AdapterEvent {

	public default String getName() {
		return this.getClass().getSimpleName();
	};
	
	public void setCancelled(boolean cancelled);
	
	public boolean isCancelled();
	
}
