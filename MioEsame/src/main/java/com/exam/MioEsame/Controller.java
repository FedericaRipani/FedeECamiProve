package com.exam.MioEsame;

import java.io.IOException;
import java.util.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.exam.Database.DatabaseMetadata;
import com.exam.Database.DatabaseTweet;
import com.exam.model.Metadati;
import com.exam.model.Tweet;
import com.exam.Service.*;
import com.exam.Statistic.*;


/**
 * 
 * Il controller rappresenta e contiene tutte le richieste che si possono
 * fare al server
 * 
 * @author Camilla D'Andrea
 * @author Federica Ripani
 */

@RestController
public class Controller {
	
	private DatabaseMetadata meta;
	private ArrayList<Tweet> vett;
	private ArrayList<Tweet> database;
	private Boolean val;
	private FilterService filterService;
	private Map<String, Object> map;
	private StatsService statService;

	public Controller() throws IOException {
		
		map=new HashMap<String, Object>();
		filterService = new FilterService();
		vett= new ArrayList<Tweet>();
		meta = new DatabaseMetadata();
		database = new DatabaseTweet().getAll();
		statService= new StatsService();
		
		System.out.println("\n\n|--------------------|");
		System.out.println("|  APPLICATION READY |");
		System.out.println("|--------------------|\n\n");
	}
	
	/**
	 * Gestisce la chiamata che fa visualizzare i metadati
	 * con un codice HTTP 200
	 * @return la collezione di metadati
	 */
	
	@GetMapping("/getMeta")
	public ResponseEntity<ArrayList<Metadati>> meta() {
		return new ResponseEntity<ArrayList<Metadati>>(meta.getAll(), HttpStatus.OK);
	
	}
	
	/**
	 * Gestisce la chiamata che fa visualizzare i tweet
	 * con un codice HTTP 200
	 * @return la collezione di tweet
	 */
	
	@GetMapping("/getTweets")
	public ResponseEntity<ArrayList<Tweet>> Twit() {
		
		return new ResponseEntity<ArrayList<Tweet>>(database, HttpStatus.OK);
	
	}
	
	/**
	 * @param filter, è il filtro inserito in formato Json nella query string
	 * @return L'Array filtrato in base alle richieste con codice HTTP 200
	 * altrimenti codice HTTP 204 se la query è stata eseguita con successo 
	 * ma non ha prodotto risultati
	 * altrimenti codice HTTP 501 se la query non è stata possibile eseguirla
	 * per adesempio una mal-implementazione
	 * @throws JSONException 
	 */
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/filtering")
	public ResponseEntity filters(@RequestParam String filter) throws JSONException {
		JSONObject filtro = new JSONObject(filter);
		vett = filterService.filters(database, filtro);
		val= filterService.getFlag();
		System.out.println(val);
		
		if(val==false)
			return new ResponseEntity<String>("Nessun filtro selezionato/esistente", HttpStatus.NOT_IMPLEMENTED);
		
		if (vett.size() == 0)
			return new ResponseEntity<String>("La ricerca non ha prodotto risultati", HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<ArrayList<Tweet>>(vett, HttpStatus.OK);
		
	}
	
	/**
	 * 
	 * 
	 * @param field
	 * @param filter
	 * @return
	 * @throws JSONException
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping("/stats")
	public ResponseEntity statistiche(@RequestParam(required = true) String field,
			@RequestParam(required = false, defaultValue = "") String filter) throws JSONException {
		map=statService.calculStat(database, field, filter);
		val=statService.getFlag();
		if(val==false)
			return new ResponseEntity<String>("Nessun filtro selezionato/esistente", HttpStatus.NOT_IMPLEMENTED);
		else
			return new ResponseEntity<Map<String, Object>>(map,HttpStatus.OK);
		
		/*
		if (filter.isEmpty()) {
			
			
			if (Arrays.asList("data", "textPost", "nameUser", "languagePost", "userMentions", "hashtag").contains(field)) {
				StringStat stat = new StringStat(database, field);
				return new ResponseEntity<Map<String, Object>>(stat.getStat().getStringhe(), HttpStatus.OK);

			}

			
			if (Arrays.asList("idPost", "idUser", "numPost").contains(field)) {
				IntegerStat stat = new IntegerStat(database, field);
				return new ResponseEntity<Map<String, Object>>(stat.getStat().getNumerici(), HttpStatus.OK);

			}
		}
		
		
		
		

		return new ResponseEntity<String>("Field immesso inesistente", HttpStatus.NOT_IMPLEMENTED);
	*/
	}
}
	

		
	

	



