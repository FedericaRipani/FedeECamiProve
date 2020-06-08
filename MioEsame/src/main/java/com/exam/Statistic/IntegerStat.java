package com.exam.Statistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import com.exam.model.Tweet;

/**
 * Classe che eredita da Stats e crea la mappa(campo-valore)
 * formata dalle statistiche numeriche 
 * 
 * @author Federica Ripani
 *
 */

public class IntegerStat extends Stats{
	
	
	private Stats T;
	private double sum;
	private double min;
	private double max;
	private double avg;
	
	
		public IntegerStat(ArrayList<Tweet> vett, String field) throws JSONException {
			super();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("Field", field);
			map.put("Sommatoria", sum = new Sum().calcola(vett, field));
			map.put("Minimo", min = new Min().calcola(vett, field));
			map.put("Massimo", max = new Max().calcola(vett, field));
			map.put("Media", avg = new Average().calcola(vett, field));
			
			T = new Stats(map);
		}

		public Stats getStat() {
			return T;
		}


}
