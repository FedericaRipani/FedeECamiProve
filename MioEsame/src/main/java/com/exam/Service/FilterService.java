package com.exam.Service;

/**
 *  Classe che, in base al JSONObject filtro passato dal'utente, 
 *  sceglie quale filtro applicare e ritorna l'array filtrato.
 * 
 * @author Camilla D'Andrea
 * @author Federica Ripani
 */

import com.exam.Filter.*;
import com.exam.model.Tweet;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

public class FilterService {

	public ArrayList<Tweet> vett;
	public JSONObject filtro;
	public ArrayList<Tweet> twits;
	public Boolean flag;

	public FilterService() {

		flag = new Boolean(false);
		twits = new ArrayList<Tweet>();
	}
	
	
	public ArrayList<Tweet> filters(ArrayList<Tweet> twits, JSONObject filtro) throws JSONException {
		
		switch (filtro.getString("type")) {

		case "UpperBound": {
			UpperBound up = new UpperBound(filtro.getString("fields"), filtro.getInt("lower"));
			vett = up.apply(twits, false);
			flag = true;
			break;
		}

		case "UpperBoundE": {
			UpperBound up = new UpperBound(filtro.getString("fields"), filtro.getInt("lower"));
			vett = up.apply(twits, true);
			flag = true;
			break;
		}

		case "LowerBound": {
			LowerBound lo = new LowerBound(filtro.getString("fields"), filtro.getInt("upper"));
			vett = lo.apply(twits, false);
			flag = true;
			break;
		}

		case "LowerBoundE": {
			LowerBound lo = new LowerBound(filtro.getString("fields"), filtro.getInt("upper"));
			vett = lo.apply(twits, true);
			flag = true;
			break;
		}

		case "Included": {
			Included in = new Included(filtro.getString("fields"), filtro.getInt("lower"), filtro.getInt("upper"));
			vett = in.apply(twits, false);
			flag = true;
			break;
		}

		case "IncludedE": {
			Included in = new Included(filtro.getString("fields"), filtro.getInt("lower"), filtro.getInt("upper"));
			vett = in.apply(twits, true);
			flag = true;
			break;
		}

		case "Search": {
			Search se = new Search(filtro.getString("fields"), filtro.getString("value"));
			vett = se.apply(twits, true);
			flag = true;
			break;
		}

		}
		return vett;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
}
