package com.exam.Service;

import java.util.ArrayList;

import com.exam.model.Tweet;

public class FilterService {

	
	public static Filter instanceFilter(String column,String operator,Object param) 
	String path="com.exam.Filter";
	Filter filtro;
	String filterName = new String(column+operator);
	String ClassFilterName = path.concat(filterName);
	ClassFilterName(param);
}
