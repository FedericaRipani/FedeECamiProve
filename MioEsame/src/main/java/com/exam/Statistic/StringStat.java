package com.exam.Statistic;

import java.util.ArrayList;

import org.json.JSONException;

import com.exam.model.Tweet;

public class StringStat {
	
	private Stats T;

	public StringStat(ArrayList<Tweet> vett, String field) throws JSONException {
		T = new Stats(Op.occorrence(vett, field), false);
	}

	public Stats getStat() {
		return T;
	}


}
