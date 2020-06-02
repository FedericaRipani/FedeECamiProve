package com.exam.Service;
import com.exam.Filter.*;
import com.exam.model.Tweet;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;


public class FilterService {
	
	public ArrayList<Tweet> vett;
	public JSONObject filtro;
	public ArrayList<Tweet> twits = new ArrayList<Tweet>();
	public Boolean flag=true;
	
	public FilterService() {
		
	}
	
	public FilterService(ArrayList<Tweet> vett, JSONObject filtro) {
		this.vett = vett;
		this.filtro=filtro; 
	}
	
	public  Boolean getFlag() {
		return flag;
	}



	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public  ArrayList<Tweet> filters(ArrayList<Tweet> twits, JSONObject filtro) throws JSONException {
	switch (filtro.getString("type")) {

	case "UpperBound":{
		  UpperBound up = new UpperBound(filtro.getString("fields"), filtro.getInt("lower"));
		  vett = up.apply(twits, false);
		  break;
		}
	
	case "UpperBoundE":{
		  UpperBound up = new UpperBound( filtro.getString("fields"), filtro.getInt("lower"));
		  vett = up.apply(twits, true);
		  break;
		}
	
	case "LowerBound":{
		LowerBound lo = new LowerBound(filtro.getString("fields"), filtro.getInt("upper"));
		vett = lo.apply(twits, false);
		break;
		}
	
	case "LowerBoundE":{
		LowerBound lo = new LowerBound(filtro.getString("fields"), filtro.getInt("upper"));
		vett = lo.apply(twits, true);
		break;
		}
	
	case "Included":{
		Included in = new Included( filtro.getString("fields"), filtro.getInt("lower"),filtro.getInt("upper"));
		vett = in.apply(twits, false);
		break;
		}
	
	case "IncludedE":{
		Included in = new Included( filtro.getString("fields"), filtro.getInt("lower"), filtro.getInt("upper"));
		vett = in.apply(twits, true);
		break;
		}
	
	case "Search":{
		Search se = new Search(filtro.getString("fields"), filtro.getString("value"));
		vett = se.apply(twits, true);
		break;
		}
	default:flag=false;
		}
	return vett ;
	}
}


