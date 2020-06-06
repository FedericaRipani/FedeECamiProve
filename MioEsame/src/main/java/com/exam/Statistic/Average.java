package com.exam.Statistic;

import java.util.ArrayList;

import com.exam.Interface.AbstactStatistic;
import com.exam.model.Tweet;

public class Average extends AbstactStatistic {
	public Average() {
		
	}
	
	/**
	 * Calcola la media di una collezione di interi
	 * 
	 * @param vett  collezione di concessione
	 * @param field attributo su cui calcolare la statistica
	 * @return media (double)
	 */
	public double calcola(ArrayList<Tweet> vett, String field) {
		return	new Sum().calcola(vett, field) / vett.size();
	}

}
