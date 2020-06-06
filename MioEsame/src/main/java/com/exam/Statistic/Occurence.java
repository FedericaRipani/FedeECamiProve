package com.exam.Statistic;

import java.util.Map;

public class Occurence {
	public Occurence() {
		
	}
	
	public static Map<String, Object> occorrence(Vector<Concessione> vett, String field) throws JSONException {

		Vector<String> vett_c = convstr(vett, field);
		Map<String, Object> map = new HashMap<String, Object>();

		int occ = 0;
		String str = null;
		Vector<String> temp = new Vector<String>();
		temp.addAll(vett_c);

		for (int i = 0; i < vett.size(); i++) {

			occ = 0;

			for (int j = 0; j < temp.size(); j++) {
				if (temp.get(j).equals(vett_c.get(i)) && !vett_c.get(i).isEmpty()) {
					occ++;
					str = temp.get(j);
					temp.removeElementAt(j);
					j--;
					map.put(str, occ);
				}
			}
		}
		return map;
	}

}
