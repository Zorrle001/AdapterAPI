package de.zorrle001.adapterapi.api;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import de.zorrle001.adapterapi.api.interfaces.AdapterHandler;
import de.zorrle001.adapterapi.api.interfaces.ListenerAdapter;

public class AnnotationFinder {
	
	public static List<Method> getAdapterAnnoation(ListenerAdapter adapter) {
	    List<Method> methods = new ArrayList<Method>();
	    
	    Class<? extends Annotation> annotation = AdapterHandler.class;
	    
	    Class<?> adapterClass = adapter.getClass();
	    if(adapterClass.isAnnotationPresent(annotation)) {
	    	return getClassMethodes(adapter);
	    }
	    
	    while (adapterClass != Object.class) {
	        for (final Method method : adapterClass.getDeclaredMethods()) {
	            if (method.isAnnotationPresent(annotation)) {
	                methods.add(method);
	            }
	        }
	        adapterClass = adapterClass.getSuperclass();
	    }
	    
	    return methods;
	}
	
	
	
	public static List<Method> getClassMethodes(ListenerAdapter adapter) {
	    List<Method> methods = new ArrayList<Method>();
	    
	    Class<?> adapterClass = adapter.getClass();
	    
	    while (adapterClass != Object.class) {
	        for (Method method : adapterClass.getDeclaredMethods()) {
	        	methods.add(method);
	        }
	        adapterClass = adapterClass.getSuperclass();
	    }
	    return methods;
	}
	
}
