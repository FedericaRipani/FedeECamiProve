package com.exam.Service;

import java.util.ArrayList;

import com.exam.model.Tweet;

public class StatsService {

	public StatsService() {
		
		
	}
	
	/**
	 * Crea una collezione di attributi della concessione in base al field
	 * 
	 * @param vett  collezione di dati da esaminare
	 * @param field attributo desiderato
	 * @return collezione di interi
	 */
	public static ArrayList<Integer> convInt(ArrayList<Tweet> vett, String field) {
		 ArrayList<Integer> ids = new ArrayList<Integer>();
		for (Tweet thing : vett) {
			switch (field) {
			case "numPost":
				ids.add(thing.getNumPost());
				break;
			case "idPost":
				ids.add(thing.getIdPost());
				break;
			case "idUser":
				ids.add(thing.getIdUser());
				break;
			default:
				return null;
			}

		}
		return ids;
	}
	
	/**
	 * Crea una collezione di attributi della concessione in base al field
	 * 
	 * @param vett  collezione di dati da esaminare
	 * @param field attributo desiderato
	 * @return collezione di stringhe
	 */
	protected static ArrayList<String> convStr(ArrayList<Tweet> vett, String field) {
		ArrayList<String> ids = new ArrayList<String>();
		for (Tweet thing : vett) {
			switch (field) {
			case "Data":
				ids.add(thing.getData());
				break;
			case "textPost":
				ids.add(thing.getTextPost());
				break;
			case "nameUser":
				ids.add(thing.getNameUser());
				break;
			case "languagePost":
				ids.add(thing.getLanguagePost());
				break;
			case "hashtag":
				ids.add(thing.getHashtag().toString());
				break;
			case "userMentions":
				ids.add(thing.getUserMentions().toString());
				break;
			default:
				return null;
			}

		}
		return ids;
	}
}
