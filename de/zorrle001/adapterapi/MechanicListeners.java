package de.zorrle001.adapterapi;

import de.zorrle001.adapterapi.api.adapter.AddListenerAdapter;
import de.zorrle001.adapterapi.api.interfaces.AdapterHandler;
import de.zorrle001.adapterapi.api.interfaces.ListenerAdapter;

public class MechanicListeners implements ListenerAdapter {

	/*@AdapterHandler
	public void onTest(StartAdapter a) {
		a.setCancelled(false);
	}*/
	
	@AdapterHandler
	public void onAdd(AddListenerAdapter a) {
		
		if(!a.getListenerAdapter().getName().equalsIgnoreCase("MechanicListeners")) {
			a.setCancelled(true);
		}
		
		if(a.isCancelled()) {
			System.out.println(a.getListenerAdapter().getName() + " wurde gecancellt");
			return;
		}
		
		if(a.isNotAdded()) {
			System.out.println(a.getListenerAdapter().getName() + " wurde erfolgreich registriert");
		}else {
			System.out.println(a.getListenerAdapter().getName() + " wurde bereits registriert");
		}
		
	}
	
}
