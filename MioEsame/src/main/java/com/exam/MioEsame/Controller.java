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
import com.exam.Filter.*;
import com.exam.model.Metadati;
import com.exam.model.Tweet;

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
	
	private static DatabaseMetadata meta = new DatabaseMetadata();
	private ArrayList<Tweet> vett= new ArrayList<Tweet>();
	protected String tipo= new String();


	public Controller() throws IOException {
		ArrayList<Tweet> database = new DatabaseTweet().getAll();
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
		return new ResponseEntity<ArrayList<Tweet>>(DatabaseTweet.getAll(), HttpStatus.OK);
	
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
		tipo=filtro.getString("type");
		vett=FilterService(DatabaseTweet.getAll(),tipo).filters(tipo);
		
		
		/*JSONObject filtro = new JSONObject(filter);
		
		
		switch (filtro.getString("type")) {

		case "UpperBound":{
			  UpperBound up = new UpperBound(filtro.getString("fields"), filtro.getInt("lower"));
			  vett = up.apply(DatabaseTweet.getAll(), false);
			  break;
			}
		
		case "UpperBoundE":{
			  UpperBound up = new UpperBound(filtro.getString("fields"), filtro.getInt("lower"));
			  vett = up.apply(DatabaseTweet.getAll(), true);
			  break;
			}
		
		case "LowerBound":{
			LowerBound lo = new LowerBound(filtro.getString("fields"), filtro.getInt("upper"));
			vett = lo.apply(DatabaseTweet.getAll(), false);
			break;
			}
		
		case "LowerBoundE":{
			LowerBound lo = new LowerBound(filtro.getString("fields"), filtro.getInt("upper"));
			vett = lo.apply(DatabaseTweet.getAll(), true);
			break;
			}
		
		case "Included":{
			Included in = new Included(filtro.getString("fields"), filtro.getInt("lower"),filtro.getInt("upper"));
			vett = in.apply(DatabaseTweet.getAll(), false);
			break;
			}
		
		case "IncludedE":{
			Included in = new Included(filtro.getString("fields"), filtro.getInt("lower"), filtro.getInt("upper"));
			vett = in.apply(DatabaseTweet.getAll(), true);
			break;
			}
		
		case "Search":{
			Search se = new Search(filtro.getString("fields"), filtro.getString("value"));
			vett = se.apply(DatabaseTweet.getAll(), true);
			break;
			}
		default:
			return new ResponseEntity<String>("Nessun filtro selezionato/esistente", HttpStatus.NOT_IMPLEMENTED);
			
		}
		if (vett.size() == 0)
			return new ResponseEntity<String>("La ricerca non ha prodotto risultati", HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<ArrayList<Tweet>>(vett, HttpStatus.OK);
	}*/
}
		
	

	



