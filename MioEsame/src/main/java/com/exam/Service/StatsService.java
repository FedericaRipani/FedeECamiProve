package com.exam.Service;

import java.util.*;

/**
 * Service dedicato al calcolo delle statistiche
 * richiamato nel controller
 * 
 * @author Federica Ripani
 */

import com.exam.model.*;

public class StatsService {
	
	
	/**
	 * Crea una collezione di attributi dei tweet in base al field
	 * 
	 * @param vett = ArrayList da esaminare
	 * @param field = campo dell'ArrayList sul quale effettuare le statistiche
	 * @return collezione di interi 
	 */
	public  ArrayList<Integer> convInt(ArrayList<Tweet> vett, String field) {
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
	 * Crea una collezione di attributi dei tweet in base al field
	 * 
	 * @param vett = ArrayList da esaminare
	 * @param field = campo dell'ArrayList sul quale effettuare le statistiche
	 * @return collezione di string
	 */
	public ArrayList<String> convStr(ArrayList<Tweet> vett, String field) {
		ArrayList<String> ids = new ArrayList<String>();
		for (Tweet thing : vett) {
			switch (field) {
			case "data":
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
	
	/**
	 * Metodo che sceglie se creare un StringStat o IntegerStat 
	 * in base al field passato dall'utente
	 * @param database = ArrayList sul quale effettuare le statistiche
	 * @param field = campo dell'ArrayList sul quale effettuare le statistiche
	 * @param filter = eventuale filtro desiderato
	 * @return le statistiche effettuata
	 */
	
	public Stats calculStat(ArrayList<Tweet> database,String field, String filter){
			
			
			/* stats per i campi di tipo stringa */
			if (Arrays.asList("data", "textPost", "nameUser", "languagePost").contains(field)) {
				StringStat stat = new StringStat(database, field);
				return stat.getStat();

			}

			/* stats per i campi di tipo numerico */
			if (Arrays.asList("idPost", "idUser", "numPost").contains(field)) {
				IntegerStat stat = new IntegerStat(database, field);
				return stat.getStat();
				}
			
			return null;
			
		
		}
	
	
	
}
