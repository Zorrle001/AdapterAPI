package de.zorrle001.adapterapi.api;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

import de.zorrle001.adapterapi.api.adapter.AddListenerAdapter;
import de.zorrle001.adapterapi.api.adapter.DisableAPIAdapters;
import de.zorrle001.adapterapi.api.adapter.EnableAPIAdapters;
import de.zorrle001.adapterapi.api.adapter.RemoveListenerAdapter;
import de.zorrle001.adapterapi.api.interfaces.AdapterEvent;
import de.zorrle001.adapterapi.api.interfaces.ListenerAdapter;

public class AdapterManager {

	static ArrayList<ListenerAdapter> adapterList = new ArrayList<ListenerAdapter>();
	static ArrayList<String> adapterNames = new ArrayList<String>();
	
	static boolean apiAdaptersEnabled = false;
	
	/**
	 * Registriert ListerAdapter nur, wenn Adapter nicht gecancelled wird
	 * <p>
	 * <h1> AddListenerAdapter in Registrierter Klasse werden bei Registrierung der eigenen
	 * Klasse nicht aufgerufen, wenn der Adapter gecancelled wird
	 * <p>
	 * @throws AlreadyRegisteredException 
	 */
	public static void addListenerAdapter(ListenerAdapter listener) {
		if(!adapterNames.contains(listener.getName())) {
			
			if(apiAdaptersEnabled) {
				AddListenerAdapter addListenerAdapter = new AddListenerAdapter(listener, true);
				callAdapter(addListenerAdapter);
				
				if(!addListenerAdapter.isCancelled()) {
					adapterList.add(listener);
					adapterNames.add(listener.getName());
				}
			}else {
				adapterList.add(listener);
				adapterNames.add(listener.getName());
			}
			
		}else {
			if(apiAdaptersEnabled) {
				AddListenerAdapter addListenerAdapter = new AddListenerAdapter(listener, false);
				callAdapter(addListenerAdapter);
			}
		}
	}
	
	/**
	 * Registriert ListerAdapter zuerst, alle Adapter, auch in neu hinzugefügter Klasse,
	 * werden ausgeführt und wenn Adapter gecancellt wird, wird der ListenerAdapter wieder
	 * entfernt
	 * <p>
	 * <h1> AddListenerAdapter in Registrierter Klasse werden bei Registrierung der eigenen
	 * Klasse aufgerufen, auch wenn das registrieren darauf gecancelled wird
	 * <p>
	 */
	public static void preAddListenerAdapter(ListenerAdapter listener) {
		if(!adapterNames.contains(listener.getName())) {
			
			adapterList.add(listener);
			adapterNames.add(listener.getName());
			
			if(apiAdaptersEnabled) {
				AddListenerAdapter addListenerAdapter = new AddListenerAdapter(listener, true);
				callAdapter(addListenerAdapter);
				
				if(addListenerAdapter.isCancelled()) {
					adapterList.remove(listener);	
					adapterNames.remove(listener.getName());
				}
			}
			
		}else {
			if(apiAdaptersEnabled) {
				AddListenerAdapter addListenerAdapter = new AddListenerAdapter(listener, false);
				callAdapter(addListenerAdapter);
			}
		}
	}
	
	public static void removeListenerAdapter(ListenerAdapter listener) {
		if(adapterNames.contains(listener.getName())) {
			
			if(apiAdaptersEnabled) {
				RemoveListenerAdapter removeListenerAdapter = new RemoveListenerAdapter(listener, true);
				callAdapter(removeListenerAdapter);
				
				if(!removeListenerAdapter.isCancelled()) {
				
					adapterList.remove(listener);
					adapterNames.remove(listener.getName());
					
				}
			}else {
				adapterList.remove(listener);
				adapterNames.remove(listener.getName());
			}
			
			
		}else {
			if(apiAdaptersEnabled) {
				RemoveListenerAdapter removeListenerAdapter = new RemoveListenerAdapter(listener, false);
				callAdapter(removeListenerAdapter);
			}
		}
	}
	
	public static void clearListenerAdapters() {
		adapterList.clear();
		adapterNames.clear();
	}
	
	public static void enableAPIAdapters() {
		
		EnableAPIAdapters enableAPIAdapters = new EnableAPIAdapters();
		callAdapter(enableAPIAdapters);
		if(!enableAPIAdapters.isCancelled()) {
			apiAdaptersEnabled = true;
		}
		
	}
	
	public static void disableAPIAdapters() {
		
		DisableAPIAdapters disableAPIAdapters = new DisableAPIAdapters();
		callAdapter(disableAPIAdapters);
		if(!disableAPIAdapters.isCancelled()) {
			apiAdaptersEnabled = false;
		}
		
	}
	
	
	
	public static void callAdapter(AdapterEvent event) {
		
		//EVENT AUFRUFEN
		
		for(ListenerAdapter listenerAdapter : adapterList) {
			
			List<Method> methodes = AnnotationFinder.getAdapterAnnoation(listenerAdapter);
			for(Method method : methodes) {
				if(method.getParameterCount() == 1) {
					Parameter parameter = method.getParameters()[0];
					if(parameter.getType() == event.getClass()) {
						
						try {
							Object instance = listenerAdapter.getClass().getDeclaredConstructor().newInstance();
							method.invoke(instance, event);
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException | NoSuchMethodException | SecurityException e) {
							e.printStackTrace();
							System.out.println("[AdapterAPI] Adapter konnte nicht aufgerufen werden");
						}
						
					}
				}
			}
			
		}
		
	}
	
}
