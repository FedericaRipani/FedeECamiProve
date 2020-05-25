package com.exam.MioEsame;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.exam.Database.DatabaseMetadata;
import com.exam.model.Metadati;

/**
 * Il controller rappresenta e contiene tutte le richieste che si possono
 * fare al server
 * @author Camilla D'Andrea
 * @author Federica Ripani
 */

@RestController
public class Controller {
	
	/**
	 * Gestisce la chiamata che fa visualizzare i metadati
	 * con un codice HTTP 200
	 * @return la collezione di metadati
	 */
	
	@GetMapping("/getMeta")
	public ResponseEntity<ArrayList<Metadati>> meta() {
		return new ResponseEntity<ArrayList<Metadati>>(DatabaseMetadata.getAll(), HttpStatus.OK);
	
	}
	


}
