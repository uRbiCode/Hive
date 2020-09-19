package model;

import java.util.Random;
import app.Main;
import ui.AppPanel;

public class Pszczola implements Runnable {
	int route;
	int dlugoscZycia;
	int number;
	int cnt = 0;
	String name;
	Random rand = new Random();
	int status;
	
	public int getStatus() {
		return status;
	}
	
	public Pszczola(String n, int x, int numb) {
		name = n;
        dlugoscZycia = x;
        number = numb;
	}

	@Override
	public void run() {
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
						AppPanel.bees.get(number - 1).move(status, number);
					}
					else {
						Ul.miejsce1_2.incrementAndGet();
						status = 2;
						AppPanel.bees.get(number - 1).move(status, number);
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
						AppPanel.bees.get(number - 1).move(status, number);
					}
					else {
						Ul.miejsce1_2.decrementAndGet();
						status = 0;
						AppPanel.bees.get(number - 1).move(status, number);
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
						AppPanel.bees.get(number - 1).move(status, number);
					}
					else {
						Ul.miejsce2_2.incrementAndGet();
						status = 4;
						AppPanel.bees.get(number - 1).move(status, number);
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
						AppPanel.bees.get(number - 1).move(status, number);
					}
					else {
						Ul.miejsce2_2.decrementAndGet();
						status = 0;
						AppPanel.bees.get(number - 1).move(status, number);
					}
					Ul.wolneMiejsca2.release();
				}
				catch(InterruptedException e){
					 e.printStackTrace();
				}
			}			
		}
		AppPanel.bees.get(number - 1).setVisible(false);
	}
}
