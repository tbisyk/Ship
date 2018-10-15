package com.gmail.t.bisyk;

public class Action {
	private int cargo;

	private boolean start = false;
	private boolean stop = false;
	volatile int ships = 3;


	public int getShips() {
		return ships;
	}

	public void setShips(int ships) {
		this.ships = ships;
	}

	public Action() {
		super();
	}

	public synchronized int getValue(int dock) {
		Thread thr = Thread.currentThread();
		for (; start == false;) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				thr.interrupt();
			}
		}
		int tempC = this.cargo;
		start = false;
		notifyAll();
		System.out.println(dock + " Dock");
		return tempC;
	}

	public synchronized void setValue(int cargo, String ship) {
		Thread thr = Thread.currentThread();
		for (; start == true;) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				thr.interrupt();
			}
		}
		this.cargo = cargo;
		start = true;
		System.out.print(ship + " - " + this.cargo + " -> ");
		notifyAll();
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
}
