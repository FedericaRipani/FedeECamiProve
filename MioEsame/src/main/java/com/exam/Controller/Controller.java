package com.exam.Controller;

import java.util.*;
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
	 * @return la collezione di metadati
	 */
	
@GetMapping("/getMetadati")
	public ArrayList<Metadati> getAll()
	{
		return DatabaseMetadata.getAll();
	}
	

}
