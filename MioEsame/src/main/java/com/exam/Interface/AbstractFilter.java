package com.exam.Interface;

import java.util.ArrayList;

import org.json.JSONException;

import com.exam.model.Tweet;

/**
 * 
 * Classe astratta creata per includere i filtri logici e condizionali da
 * implementare. I filtri dovranno di conseguenza implementare i metodi approved
 * e applica.
 *
 */

public abstract class AbstractFilter {
	
	
		protected String fields;

		public AbstractFilter(String fields) {
			setFields(fields);
		}

		public String getFields() {
			return fields;
		}

		public void setFields(String fields) {
			this.fields = fields;
		}

		public abstract boolean approved(Tweet elem, boolean equal) throws JSONException;

		public abstract ArrayList<Tweet> apply(ArrayList<Tweet> list, boolean equal) throws JSONException;
	

}
