package de.zorrle001.adapterapi.api.adapter;

import de.zorrle001.adapterapi.api.interfaces.AdapterEvent;
import de.zorrle001.adapterapi.api.interfaces.ListenerAdapter;

public class AddListenerAdapter implements AdapterEvent {

	boolean cancelled = false;
	boolean notAdded;
	
	ListenerAdapter adapter;
	
	public AddListenerAdapter(ListenerAdapter adapter, boolean notAdded) {
		this.adapter = adapter;
		this.notAdded = notAdded;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public boolean isCancelled() {
		return cancelled;
	}
	
	
	public boolean isNotAdded() {
		return notAdded;
	}
	
	public ListenerAdapter getListenerAdapter() {
		return adapter;
	}

}
