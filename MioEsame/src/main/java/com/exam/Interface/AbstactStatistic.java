package com.exam.Interface;

import java.util.ArrayList;


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
	
	
	
	public AbstactStatistic() {
		
	}
		
	
	public abstract double calcola(ArrayList<Tweet> vett, String field);
	
	
	
}
