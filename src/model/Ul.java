package model;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import app.Main;

public class Ul {
	static volatile AtomicInteger pszczolyWulu = new AtomicInteger(0);
	static volatile Semaphore wolneMiejsca1 = new Semaphore(1);
	static volatile Semaphore wolneMiejsca2 = new Semaphore(1);
	static volatile Semaphore KrolowaSemaphore = new Semaphore(1);
	public static int birthRate;
	
	///
	static volatile AtomicInteger miejsce1_1 = new AtomicInteger(0);
	static volatile AtomicInteger miejsce1_2 = new AtomicInteger(0);
	static volatile AtomicInteger miejsce2_1 = new AtomicInteger(0);
	static volatile AtomicInteger miejsce2_2 = new AtomicInteger(0);
	///
	
	public static int liczMiejsce(int K) {
		int tmp = K/2;
		if(tmp * 2 < K) {
			Ul.wolneMiejsca1 = new Semaphore(tmp);
			Ul.wolneMiejsca2 = new Semaphore(tmp+1);
			return (tmp+1);
		}
		else {
			Ul.wolneMiejsca1 = new Semaphore(tmp);
			Ul.wolneMiejsca2 = new Semaphore(tmp);
			return (tmp);
		}
	}
    
	
	public static synchronized void printMessage(String name, int number, int route, int cnt, String status) {
	        synchronized (Ul.class) {
	        	System.out.println(name + number + " " + status + " po raz " + cnt  + " wejœciem " + (route + 1) + ". Stan w ulu: " + Ul.pszczolyWulu.get() + "/" + Main.K);
	        }
	 }
	public static synchronized void printBday(String name, int number, String status) {
        synchronized (Ul.class) {
        	System.out.println(name + number + " " + status + "! Stan w ulu: " + Ul.pszczolyWulu.get() + "/" + Main.K);
        }        
	}
	public static synchronized void printOut(String name, int number, String status) {
        synchronized (Ul.class) {
        	System.out.println(name + number + " " + status + " Stan w ulu: " + Ul.pszczolyWulu.get() + "/" + Main.K);
        }
	}
}

