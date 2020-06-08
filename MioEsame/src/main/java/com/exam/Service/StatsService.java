package com.exam.Service;

import java.util.*;
import com.exam.MioEsame.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.exam.Statistic.*;

import com.exam.model.Tweet;

public class StatsService {
	
    public String field;
    public String filter;
    public ArrayList<Tweet> database;
    public Boolean flag;
	
	
	@SuppressWarnings("deprecation")
	public StatsService() {
		
		flag = new Boolean(false);
		database = new ArrayList<Tweet>();
		
	}
	
	/**
	 * Crea una collezione di attributi della concessione in base al field
	 * 
	 * @param vett  collezione di dati da esaminare
	 * @param field attributo desiderato
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
				System.out.println("Sono entrato in id");
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
				System.out.println("Default");
				return null;
			}

		}
		return ids;
	}
	
	public Stats calculStat(ArrayList<Tweet> database,String field, String filter){
		
		
			if (filter.isEmpty()) {
			
			/* stats per i campi di tipo stringa */
			if (Arrays.asList("data", "textPost", "nameUser", "languagePost", "userMentions", "hashtag").contains(field)) {
				
				StringStat stat = new StringStat(database, field);
				flag=true;
				return stat.getStat();

			}

			/* stats per i campi di tipo numerico */
			if (Arrays.asList("idPost", "idUser", "numPost").contains(field)) {
				IntegerStat stat = new IntegerStat(database, field);
				flag=true;
				return stat.getStat();
				}
			}
			//return null;
			
			else if (!filter.isEmpty()) {
			
			//if(filters(filter).getStatusCode() != HttpStatus.OK) return new ResponseEntity<String>("Selezione dati per statistiche vuota", HttpStatus.NOT_FOUND);

			/*
			 * se il campo immesso è giusto e il filtro produrrà una risposta giusta (cioè
			 * esiste) calcoliamo le stats*/
			 
			if (Arrays.asList("data", "textPost", "nameUser", "languagePost").contains(field)) {

				@SuppressWarnings("unchecked")
				ArrayList<Tweet> filtrati = (ArrayList<Tweet>)filters(filter).getBody();
				StringStat stat = new StringStat(filtrati, field);
				return stat.getStat();
			}

			/*
			 * se il campo immesso è giusto e il filtro produrrà una risposta giusta (cioè
			 * esiste) calcoliamo le stats*/
			 
			if (Arrays.asList("idPost", "idUser", "numPost").contains(field)) {

				@SuppressWarnings("unchecked")
				ArrayList<Tweet> filtrati = (ArrayList<Tweet>)filters(filter).getBody();
				IntegerStat stat = new IntegerStat(filtrati, field);
				return stat.getStat();
			}
		}
		
		}
	public Boolean getFlag() {
		return flag;
	}	
	
	
}
