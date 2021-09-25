package de.zorrle001.adapterapi;

import de.zorrle001.adapterapi.api.AdapterManager;

public class Main extends AdapterManager {

	public static void main(String[] args) throws InterruptedException {
		
		enableAPIAdapters();
		
		addListenerAdapter(new TestListener());
		preAddListenerAdapter(new TestListener());
		clearListenerAdapters();
		removeListenerAdapter(new TestListener());
		
	}
	
}
