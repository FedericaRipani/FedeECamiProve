package com.exam.Filter;
import java.util.ArrayList;

import com.exam.Database.*;
import com.exam.model.Tweet;

public class UpperBound{
	
	
	public static ArrayList<Tweet> data = DatabaseTweet.getAll();
	
	public int length = data.size();
	
	for(int j=0; j<length; j++)
		if(data."listed_count"[j]>parametroFiltro)
			return data[j];
}
