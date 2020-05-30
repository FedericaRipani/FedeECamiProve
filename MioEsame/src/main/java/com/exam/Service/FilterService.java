package com.exam.Service;
import com.exam.Database.DatabaseTweet;
import com.exam.Filter.*;
import com.exam.model.Tweet;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;


public class FilterService {
	
	public ArrayList<Tweet> vett;
	public String filtro;

	
	public FilterService(ArrayList<Tweet> vett,String filtro) {
		this.vett = vett;
		this.filtro=filtro; 
	}


	public  ArrayList<Tweet> filters(String filtro) throws JSONException {
	switch (filtro) {

	case "UpperBound":{
		  UpperBound up = new UpperBound(filtro.getString("fields"), filtro.getInt("lower"));
		  vett = up.apply(DatabaseTweet.getAll(), false);
		  break;
		}
	
	case "UpperBoundE":{
		  UpperBound up = new UpperBound(filtro.getString("fields"), filtro.getInt("lower"));
		  vett = up.apply(DatabaseTweet.getAll(), true);
		  break;
		}
	
	case "LowerBound":{
		LowerBound lo = new LowerBound(filtro.getString("fields"), filtro.getInt("upper"));
		vett = lo.apply(DatabaseTweet.getAll(), false);
		break;
		}
	
	case "LowerBoundE":{
		LowerBound lo = new LowerBound(filtro.getString("fields"), filtro.getInt("upper"));
		vett = lo.apply(DatabaseTweet.getAll(), true);
		break;
		}
	
	case "Included":{
		Included in = new Included(filtro.getString("fields"), filtro.getInt("lower"),filtro.getInt("upper"));
		vett = in.apply(DatabaseTweet.getAll(), false);
		break;
		}
	
	case "IncludedE":{
		Included in = new Included(filtro.getString("fields"), filtro.getInt("lower"), filtro.getInt("upper"));
		vett = in.apply(DatabaseTweet.getAll(), true);
		break;
		}
	
	case "Search":{
		Search se = new Search(filtro.getString("fields"), filtro.getString("value"));
		vett = se.apply(DatabaseTweet.getAll(), true);
		break;
		}	
		}
	return vett;
	}
}


