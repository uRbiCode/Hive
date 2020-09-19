package model;

import java.util.Random;

import app.Main;
import ui.AppPanel;

public class PszczolaNowa implements Runnable {
	int route;
	int dlugoscZycia;
	int number;
	int cnt = 0;
	String name;
	Random rand = new Random();
	int status;
	
	public PszczolaNowa(String n, int x, int numb) {
		name = n;
        dlugoscZycia = x;
        number = numb;
	}
	
	public void beBorned() {
		for(int i = 0; i < 1;) {
			try {
				Ul.wolneMiejsca2.acquire();
				Ul.pszczolyWulu.incrementAndGet();
				if(Ul.miejsce2_1.get() == 0) {
					Ul.miejsce2_1.incrementAndGet();
					status = 3;
					AppPanel.newbees.get(number - 1 - Main.N).move(status, number);
				}
				else {
					Ul.miejsce2_2.incrementAndGet();
					status = 4;
					AppPanel.newbees.get(number - 1 - Main.N).move(status, number);
				}
				AppPanel.newbees.get(number - 1 - Main.N).setVisible(true);
				Ul.printBday(name, number, "urodzi³a siê");
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}

	@Override
	public void run() {
		
		//narodzenie
		this.beBorned();
		
		//czynnosci w ulu
		try {
			Thread.sleep(rand.nextInt(15000)+1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//wylot
		Ul.pszczolyWulu.decrementAndGet();
		Ul.printOut(name, number, "opuœci³a ul pierwszy raz wejœciem 2");		
		if(status == 3) {
			Ul.miejsce2_1.decrementAndGet();
			status = 0;
			AppPanel.newbees.get(number - 1 - Main.N).move(status, number);
		}
		else {
			Ul.miejsce2_2.decrementAndGet();
			status = 0;
			AppPanel.newbees.get(number - 1 - Main.N).move(status, number);
		}
		Ul.wolneMiejsca2.release();
		
		for(int i = 0; i < Main.zyciePszczoly;) {
			route = rand.nextInt(2);
			if(route == 0 && Ul.KrolowaSemaphore.availablePermits() > 0) {
				try {
					//wlot
					Thread.sleep(rand.nextInt(5000)+1000);
					Ul.wolneMiejsca1.acquire();
					Ul.pszczolyWulu.incrementAndGet();
					cnt++;
					if(Ul.miejsce1_1.get() == 0) {
						Ul.miejsce1_1.incrementAndGet();
						status = 1;
						AppPanel.newbees.get(number - 1 - Main.N).move(status, number);
					}
					else {
						Ul.miejsce1_2.incrementAndGet();
						status = 2;
						AppPanel.newbees.get(number - 1 - Main.N).move(status, number);
					}
					Ul.printMessage(name, number, route, cnt, "wlecia³a");
					
					//czynnosci w ulu
					Thread.sleep(rand.nextInt(200)+500);
					
					//wylot
					Ul.pszczolyWulu.decrementAndGet();
					i++;
					Ul.printMessage(name, number, route, cnt, "wylecia³a");
					if(status == 1) {
						Ul.miejsce1_1.decrementAndGet();
						status = 0;
						AppPanel.newbees.get(number - 1 - Main.N).move(status, number);
					}
					else {
						Ul.miejsce1_2.decrementAndGet();
						status = 0;
						AppPanel.newbees.get(number - 1 - Main.N).move(status, number);
					}
					Ul.wolneMiejsca1.release();
				}
				catch(InterruptedException e){
					 e.printStackTrace();
				}
			}
			else if (Ul.KrolowaSemaphore.availablePermits() > 0){
				try {
					//wlot
					Thread.sleep(rand.nextInt(5000)+1000);
					Ul.wolneMiejsca2.acquire();
					Ul.pszczolyWulu.incrementAndGet();
					cnt++;
					if(Ul.miejsce2_1.get() == 0) {
						Ul.miejsce2_1.incrementAndGet();
						status = 3;
						AppPanel.newbees.get(number - 1 - Main.N).move(status, number);
					}
					else {
						Ul.miejsce2_2.incrementAndGet();
						status = 4;
						AppPanel.newbees.get(number - 1 - Main.N).move(status, number);
					}
					Ul.printMessage(name, number, route, cnt, "wlecia³a");
					
					//czynnosci w ulu
					Thread.sleep(rand.nextInt(200)+500);
					
					//wylot
					Ul.pszczolyWulu.decrementAndGet();
					i++;
					Ul.printMessage(name, number, route, cnt, "wylecia³a");		
					if(status == 3) {
						Ul.miejsce2_1.decrementAndGet();
						status = 0;
						AppPanel.newbees.get(number - 1 - Main.N).move(status, number);
					}
					else {
						Ul.miejsce2_2.decrementAndGet();
						status = 0;
						AppPanel.newbees.get(number - 1 - Main.N).move(status, number);
					}
					Ul.wolneMiejsca2.release();
				}
				catch(InterruptedException e){
					 e.printStackTrace();
				}
			}
		}
		AppPanel.newbees.get(number - 1 - Main.N).setVisible(false);
	}
}
