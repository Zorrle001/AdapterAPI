package de.zorrle001.adapterapi;

import de.zorrle001.adapterapi.api.adapter.AddListenerAdapter;
import de.zorrle001.adapterapi.api.interfaces.AdapterHandler;
import de.zorrle001.adapterapi.api.interfaces.ListenerAdapter;

@AdapterHandler
public class TestListener implements ListenerAdapter {

	public void onAdd(AddListenerAdapter a) {
		System.out.println(a.getListenerAdapter().getName() + " hat hart gekickt lel :D");
	}
	
}
