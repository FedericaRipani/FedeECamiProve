package com.exam.Service;
import com.exam.Database.DatabaseTweet;
import com.exam.Filter.*;
import com.exam.model.Tweet;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class FilterService {
	
	public ArrayList<Tweet> vett;
	public JSONObject filtro ;
	
	
	public FilterService(String filter) {
		this.vett = new ArrayList<Tweet>();
		this.filtro = new JSONObject(filter);
	}
	
	//@SuppressWarnings("rawtypes")
	public  ResponseEntity filters() throws JSONException {
	switch (filtro.getString("type")) {

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
	default:
		return new ResponseEntity<String>("Nessun filtro selezionato/esistente", HttpStatus.NOT_IMPLEMENTED);
		
		}
	if (vett.size() == 0)
		return new ResponseEntity<String>("La ricerca non ha prodotto risultati", HttpStatus.NO_CONTENT);
	
	return new ResponseEntity<ArrayList<Tweet>>(vett, HttpStatus.OK);
	}
}


