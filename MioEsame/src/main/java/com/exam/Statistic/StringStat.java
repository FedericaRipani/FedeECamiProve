package com.exam.Statistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

import com.exam.model.Tweet;

public class StringStat {
	
	private Stats T;

	
	public StringStat() {
	}
	

	public StringStat(ArrayList<Tweet> vett, String field) throws JSONException {
		
		super();
		Map<String, Object> map = new HashMap<String, Object>();
		map = new Occurence().occorrence(vett, field);
		
		T = new Stats(map);
	}

	public Stats getStat() {
		return T;
	}


}
