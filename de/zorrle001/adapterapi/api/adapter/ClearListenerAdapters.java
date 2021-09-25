package de.zorrle001.adapterapi.api.adapter;

import de.zorrle001.adapterapi.api.interfaces.AdapterEvent;

public class ClearListenerAdapters implements AdapterEvent {

	boolean cancelled = false;

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public boolean isCancelled() {
		return cancelled;
	}
	
}
