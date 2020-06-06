package com.exam.Statistic;

import java.util.ArrayList;

import com.exam.Interface.AbstactStatistic;
import com.exam.Service.StatsService;
import com.exam.model.*;

public class Min extends AbstactStatistic {
	
	public Min() {
		
	}
	/**
	 * Calcola il minimo di una collezione di interi
	 * 
	 * @param vett  collezione di concessione
	 * @param field attributo su cui calcolare la statistica
	 * @return minimo (int)
	 */
	public double calcola(ArrayList<Tweet> vett, String field) {
		ArrayList<Integer> temp = new StatsService().convInt(vett, field);

		if (temp.size() == 0)
			return 0;
		else {
			int minimum = temp.get(0);
			for (int i = 0; i < temp.size(); i++) {
				if (temp.get(i) < minimum)
					minimum = temp.get(i);
			}
			return minimum;
		}
	}
}
