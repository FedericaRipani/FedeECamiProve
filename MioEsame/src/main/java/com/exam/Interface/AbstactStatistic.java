package com.exam.Interface;

import java.util.ArrayList;
import java.util.Map;

import com.exam.model.Tweet;
/** 
 * Classe astratta creata per includere il metodo che poi
 * ogni particolare statistica andrà ad implementare con il suo
 * funzionamento 
 * 
 * @author Camilla D'Andrea
 *
 */
public abstract class AbstactStatistic {
	
	//private Map<String, Object> map;
	
	public AbstactStatistic() {
		
	}
	
   // public abstract void Stats(Map<String, Object> map, boolean numbers);
		
	
	public abstract int calcola(ArrayList<Tweet> vett, String field);
	
	
	
}
