package com.gmail.t.bisyk;

public class DokcTwo implements Runnable {

	private Action ac;

	public DokcTwo(Action ac) {
		super();
		this.ac = ac;
	}

	@Override
	public void run() {
		Thread thr = Thread.currentThread();
		if (ac.ships == 0) {
			thr.interrupt();
		} else {
			ac.setShips(ac.ships - 1);
		}
		for (; !ac.isStop();) {
			int number = ac.getValue(2);
		}
	}

}