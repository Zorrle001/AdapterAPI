package de.zorrle001.adapterapi.api.adapter;

import de.zorrle001.adapterapi.api.interfaces.AdapterEvent;
import de.zorrle001.adapterapi.api.interfaces.ListenerAdapter;

public class RemoveListenerAdapter implements AdapterEvent {

	boolean cancelled = false;
	boolean alreadyRegistered;
	
	ListenerAdapter adapter;
	
	public RemoveListenerAdapter(ListenerAdapter adapter, boolean alreadyRegistered) {
		this.adapter = adapter;
		this.alreadyRegistered = alreadyRegistered;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public boolean isCancelled() {
		return cancelled;
	}
	
	
	public boolean isAlreadyRegistered() {
		return alreadyRegistered;
	}
	
	public ListenerAdapter getListenerAdapter() {
		return adapter;
	}
	
}
