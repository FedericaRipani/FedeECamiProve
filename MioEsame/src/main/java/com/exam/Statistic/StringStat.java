package com.exam.Statistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

import com.exam.model.Tweet;

public class StringStat {
	
	private Stats T;
	private Occurence occ;
	
	public StringStat() {
		occ = new Occurence();
		
	}
	

	public StringStat(ArrayList<Tweet> vett, String field) throws JSONException {
		
		super();
		
		T = new Stats(occ.occorrence(vett, field));
	}

	public Stats getStat() {
		return T;
	}


}
