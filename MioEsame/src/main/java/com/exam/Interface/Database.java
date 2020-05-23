package com.exam.Interface;

import java.util.ArrayList;

/**
 * Interfaccia generica che implementa dei metodi base,
 * che le classi database opportune andranno ad implementare.
 * @author Camilla D'Andrea
 * @author Federica Ripani
 *
 * @param <T>
 */
public interface Database<T> {
	 
	ArrayList<T> getAll();
	String toString();	

}
