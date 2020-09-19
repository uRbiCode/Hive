package app;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.awt.EventQueue;

import model.Krolowa;
import model.Pszczola;
import model.Ul;
import ui.AppMainFrame;
import ui.AppMenuFrame;

/**
 * @author Patryk Urbañski 
 */

public class Main {
	
	public static int zyciePszczoly = 10;
	public static int K = 4;
	public static int N = 10;
	public static boolean menu = true;

	public static void main(String[] args) {
		
		///
		EventQueue.invokeLater( () -> {

			new AppMenuFrame();
		});
		///

		while(menu)
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		///
		EventQueue.invokeLater( () -> {

			new AppMainFrame();
		});
		///
		
		Ul.birthRate = Ul.liczMiejsce(K);
		LinkedList<Thread> watki = new LinkedList<Thread>();
		Thread test = new Thread();
		watki.add(0, test);
		
		for(int i = 1; i <= N; i++) {
			Pszczola newborn = new Pszczola("Pszczola-", zyciePszczoly, i);
			Thread watekPszczoly = new Thread(newborn);
			watki.add(i, watekPszczoly);
		}
		for(int i = 1; i <= N; i++) {
			watki.get(i).start();
		}
		Krolowa krolowa = new Krolowa();
		krolowa.birth();
		for(int i = 1; i <= N; i++) {
			try {
				watki.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}