package com.exam.MioEsame;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import com.exam.Service.*;
import com.exam.Statistic.*;
import com.exam.model.*;

class testProva {
	
	Tweet t1;
	Tweet t2;
	ArrayList<Tweet> array;
	@BeforeEach
	void setUp() throws Exception {
	Tweet t1 = new Tweet("11Sett", 012345,"Ciao" , 110999, "Cami", 0, "it", null,null) ;
	Tweet t2 = new Tweet("23Mag", 543210,"Giulianova è top" , 230599, "Fede", 0, "it", null,null) ;
	array= new ArrayList<Tweet>();
	//come dico che dentro l'array ho quei due tweet?
	
	}
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		assertEquals{"230599",Max().calcola(array,"numPost")};
		//perchè nn è definito se lo richiamo?
		//perchè nn prende assert?
		fail("Not yet implemented");
	}

}
