package com.exam.Interface;

import java.util.ArrayList;

/**
 * Interfaccia generica dei database,
 * contenente metodi elementari come restituire o aggiungere dati.
 *
 *@author Federica Ripani
 *@author Camilla D'Andrea
 *
 *@param <T> generico
 */

public interface InterfaceDatabase<T> {
	
	void add(T param);
	ArrayList<T> getAll();

}
