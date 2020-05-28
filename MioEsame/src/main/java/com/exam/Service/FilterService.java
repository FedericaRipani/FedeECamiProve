package com.exam.Service;

import java.util.ArrayList;

import com.exam.model.Tweet;

public class FilterService {

	
	public static ArrayList<Tweet> runFilter(Filter filtro, ArrayList<Tweet> array){

		ArrayList<Tweet> filteredArray = new ArrayList<Tweet>();
		
		for(Tweet record :  array) {

			if(filtro.filter(record))
				filteredArray.add(record);
		}				
		
		return filteredArray;
	}

}
