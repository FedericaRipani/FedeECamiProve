package com.exam.Filter;
import java.util.ArrayList;

import com.exam.Database.*;
import com.exam.model.Tweet;

public class UpperBound(int param){
	
	private int parametroFiltro;
	
	public UpperBound(int par) {
		this.parametroFiltro=par;
	}
	
	public static ArrayList<Tweet> data = DatabaseTweet.getAll();
	public ArrayList<Tweet> filteredArray = new ArrayList<Tweet>();
	
	public int length = data.size();
	
	for(int j=0; j<length; j++)
		if(data.listed_count[j]>parametroFiltro)
			filteredArray.add(data[j]);
	return filteredArray;
}
