package de.zorrle001.adapterapi.adapter;

import de.zorrle001.adapterapi.api.interfaces.AdapterEvent;

public class StartAdapter implements AdapterEvent {
	
	boolean cancelled = false;

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public boolean isCancelled() {
		return cancelled;
	}
	
}
