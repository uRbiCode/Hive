package model;

import java.util.LinkedList;
import java.util.Random;
import app.Main;
import ui.AppPanel;


public class Krolowa {
	
	public static int cnt = Main.N - Ul.birthRate;
    private Random rand = new Random();
	
	public static LinkedList<Thread> watki = new LinkedList<Thread>();
	static Thread test = new Thread();
	
	public void birth() {
		for(int i = 0; i <= Main.N; i++) watki.add(i, test);
		while(true) {			
			try {
				Thread.sleep(10000);
				cnt+=Ul.birthRate;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			/////
			try {
	            Thread.sleep(rand.nextInt(7500) + 1000);
	            Ul.KrolowaSemaphore.acquire();
	            for (int i = 0; i < Ul.pszczolyWulu.get(); i++) {
	                Ul.wolneMiejsca2.acquire();
	            }
			}
			catch (InterruptedException e) {
                e.printStackTrace();
            }
	        //////    
			for(int i = 1; i <= Ul.birthRate; i++) {
				PszczolaNowa newborn = new PszczolaNowa("Nowa pszczola-", Main.zyciePszczoly, cnt+i);
				Thread watekPszczoly = new Thread(newborn);
				watki.add(cnt+i, watekPszczoly);
			}
            AppPanel.newBees(Ul.birthRate);
			for(int i = 1; i <= Ul.birthRate; i++) {
				watki.get(cnt+i).start();
			}
			for (int i = 0; i < Ul.pszczolyWulu.get(); i++) {
	        	Ul.wolneMiejsca2.release();
	        }
			Ul.KrolowaSemaphore.release();
			for(int i = 1; i <= Ul.birthRate; i++) {
				try {
					watki.get(cnt+i).join();
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}	
}
