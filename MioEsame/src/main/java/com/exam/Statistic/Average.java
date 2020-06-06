package com.exam.Statistic;

import java.util.ArrayList;

import com.exam.model.Tweet;

public class Average {
	public Average() {
		
	}
	
	/**
	 * Calcola la media di una collezione di interi
	 * 
	 * @param vett  collezione di concessione
	 * @param field attributo su cui calcolare la statistica
	 * @return media (double)
	 */
	public static double avg(ArrayList<Tweet> vett, String field) {
		return sum(vett, field) / vett.size();
	}

}
