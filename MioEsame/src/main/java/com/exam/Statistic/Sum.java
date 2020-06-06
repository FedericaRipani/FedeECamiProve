package com.exam.Statistic;

import java.util.ArrayList;

import com.exam.Interface.AbstactStatistic;
import com.exam.Service.StatsService;
import com.exam.model.Tweet;

public class Sum extends AbstactStatistic {
	
	public Sum() {
		
	}
	
	/**
	 * Calcola la somma di una collezione di interi
	 * 
	 * @param vett  collezione di concessione
	 * @param field attributo su cui calcolare la statistica
	 * @return somma (int)
	 */
	public double calcola(ArrayList<Tweet> vett, String field) {
		int somma = 0;
		ArrayList<Integer> temp = new StatsService().convInt(vett, field);
		for (int i = 0; i < temp.size(); i++)
			somma = somma + temp.get(i);
		return somma;
	}

}