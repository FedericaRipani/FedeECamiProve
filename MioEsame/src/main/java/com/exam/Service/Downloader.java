package com.exam.Service;

import java.io.IOException;
import java.net.URL;
import org.apache.commons.io.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.charset.Charset;

/**
 * 
 * Classe che permette di prendere dei dati in formato JSON da un URL
 * tramite il metodo DownloaderJson;
 * 
 * @author Federica Ripani
 */


public class Downloader {
	
     public Downloader() {
    	 
     }
     
	 public JSONArray DownloaderJson() throws IOException {
			
		JSONObject json_ob = new JSONObject(IOUtils.toString(
			new URL("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=terremoto&count=100//"), 
			Charset.forName("UTF-8")));
	
		JSONArray array = new JSONArray(json_ob.get("statuses").toString());
		
		/*for(int i = 0; i < array.length(); i++) {
			System.out.println((i+1) + ") " + 
				    array.getJSONObject(i).getInt("id") +
				    array.getJSONObject(i).getString("created_at") +
				    array.getJSONObject(i).getString("text"));
		}*/
		return array;
	
	}
	
	
}
	
