package com.gmail.t.bisyk;

public class ShipTwo implements Runnable{
	
	private Action ac;

	public ShipTwo(Action ac) {
		super();
		this.ac = ac;
	}

	@Override
	public void run() {
		Thread thr = Thread.currentThread();
		ac.setStop(false);
		for(int i=1;i<5;i++) {
			try {
				thr.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
				thr.interrupt();
			}
			ac.setValue(i,"ShipTwo");
		}
		ac.setStop(true);
		thr.interrupt();
	}

}