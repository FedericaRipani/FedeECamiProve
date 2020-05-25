package com.exam.Database;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.exam.model.*;
import com.exam.Service.*;

/**
 * Definisce un array list di Tweet
 * @return ArrayList di oggetti di tipo Tweet
 * 
 * @author Federica Ripani
 */

public class DatabaseTweet{
	
	private static ArrayList<Tweet> tweets;
	private JSONArray JsonArray;
	
	public DatabaseTweet() throws IOException{
		
		 JsonArray = new Downloader().DownloaderJson();
		 tweets = new ArrayList<Tweet>(); 
		 
		 for (int i=0; i<JsonArray.length(); i++) {
			 
			 JSONObject json = JsonArray.getJSONObject(i);
			
			
			 tweets.add(new Tweet(json.getString("created_at"),
					 			  json.getInt("id_str"),
					 			  json.getString("text"), 
					 			  json.getInt("id_str"), 
					 			  json.getString("source"),
					 			  json.getInt("id_str"),
					 			  json.getString("text"), 
					 			  json.getString("text"),
					 			  json.getString("text")));
			 
		
			 
			}
	}
	
	public static ArrayList<Tweet> getDatabase() {
		return tweets;
	}
}