package com.exam.Statistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

import com.exam.Interface.AbstactStatistic;
import com.exam.model.Tweet;

public class IntegerStat extends AbstactStatistic(){
	

		private  T;

		public IntegerStat(ArrayList<Tweet> vett, String field) throws JSONException {

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("Field", field);
			map.put("Sommatoria", Op.sum(vett, field));
			map.put("Minimo", Op.minimum(vett, field));
			map.put("Massimo", Op.maximum(vett, field));
			map.put("Media", Op.avg(vett, field));
			map.put("Deviazione STD", Op.devstd(vett, field));
			map.put("Count", Op.count(vett));

			T = new Stats(map, true);
		}

		public Stats getStat() {
			return T;
		}


}
