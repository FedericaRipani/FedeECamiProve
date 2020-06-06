package com.exam.Statistic;

import java.util.ArrayList;

import com.exam.Interface.*;
import com.exam.model.Tweet;
import com.exam.Service.*;

public class Max  extends AbstactStatistic {
	
	public Max() {
		
	}
	
	/**
	 * Calcola il massimo di una collezione di interi
	 * 
	 * @param vett  collezione di concessione
	 * @param field attributo su cui calcolare la statistica
	 * @return massimo (int)
	 */
	public double calcola(ArrayList<Tweet> vett, String field) {
		ArrayList<Integer> temp = new StatsService().convInt(vett, field);

		if (temp.size() == 0)
			return 0;
		else {
			int maximum = temp.get(0);
			for (int i = 0; i < temp.size(); i++) {
				if (temp.get(i) > maximum)
					maximum = temp.get(i);
			}
			return maximum;
		}
	}
}
