package com.exam.Filter;
import java.util.ArrayList;

import com.exam.Database.*;
import com.exam.model.Tweet;

public class UpperBound(){
	
	private int parametroFiltro;
	
	public int parametro (int param) {
		int Param = param;
		return Param;
	}
	

	
	public UpperBound(int Param) {
		int par;
		this.parametroFiltro=par;
	}
	
	public static ArrayList<Tweet> data = DatabaseTweet.getAll();
	public ArrayList<Tweet> filteredArray = new ArrayList<Tweet>();
	
	/*public*/ int length = data.length();
	
	for(int j=0; j<length; j++)
		if(data.listed_count[j]>parametroFiltro)
			filteredArray.add(data[j]);
	return filteredArray;
}
