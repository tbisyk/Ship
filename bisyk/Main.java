package com.gmail.t.bisyk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		Action ac = new Action();

		ShipOne shOne = new ShipOne(ac);
		ShipTwo shTwo = new ShipTwo(ac);
		ShipThree shThree = new ShipThree(ac);
		
		DokcOne dOne = new DokcOne(ac);
		DokcTwo dTwo = new DokcTwo(ac);

		ExecutorService  es =  Executors.newFixedThreadPool(4);
		
		es.execute(shOne);
		es.execute(shTwo);
		
		es.execute(dOne);
		es.execute(dTwo);
		
		es.execute(shThree);
		es.shutdown();
	}

}
