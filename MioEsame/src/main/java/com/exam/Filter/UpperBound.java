package com.exam.Filter;
import java.util.ArrayList;

import com.exam.model.*;
import com.exam.Interface.*;


public class UpperBound extends AbstractFilter  {
	
	private int lower;
	
	public UpperBound(String fields, int lowers) {
		super(fields);
		setLower(lowers);
	}
	
	public int getLower() {
		return lower;
	}

	public void setLower(int lower) {
		this.lower = lower;
	}

	public boolean approved(Tweet data, boolean equal)
	{
		boolean approvato = true;
		if(data.getTextPost().length()<lower)
			approvato=false;
		return approvato;
	}
	
	
	
	
	public ArrayList<Tweet> apply (ArrayList<Tweet> list, boolean equal) {
		ArrayList<Tweet> filtredArray = new ArrayList<Tweet>();
		for (int i = 0; i < list.size(); i++) {
			if (approved(list.get(i), equal)) {
				filtredArray.add(list.get(i));
			}
		}

		return filtredArray;
	}
}

