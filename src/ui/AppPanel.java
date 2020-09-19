package ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import app.Main;
import constants.Constants;
import image.Image;
import image.ImageFactory;
import model.Krolowa;
import representation.Bee;

public class AppPanel extends JPanel {
	
	private ImageIcon backgroundImage;
	private Timer timer;
	public static List<Bee> bees;
	public static List<Bee> newbees;
	private boolean inApp = true;
	
	public AppPanel() {
		initializeVariables();
		initializeLayout();
		initializeApp();
	}
	
	public void initializeApp() {
		for(int i = 0; i < Main.N; i++) {
			Bee bee = new Bee(720, 30 + 70 * i);
			bees.add(bee);
		}
	}

	private void initializeVariables() {
		bees = new ArrayList<>();
		newbees = new ArrayList<>();
		this.backgroundImage = ImageFactory.createImage(Image.BACKGROUND);
		this.timer = new Timer(Constants.APP_SPEED, new AppLoop(this));
		this.timer.start();
	}

	private void initializeLayout() {
		setFocusable(true);
		setPreferredSize(new Dimension(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(backgroundImage.getImage(), 0, 0, null);
		
		doDrawing(g);
	}

	public void doOneLoop() {
		update();
		repaint();	
	}

	private void update() {
		for(int i = 0; i < Main.N; i++) {
			if(bees.get(i).isVisible())
				bees.get(i).move();
		}
	}
	
	private void doDrawing(Graphics g) {
		if(inApp) {
			drawFirstBees(g);
			drawNewBees(g);
		}
		else if(timer.isRunning()) timer.stop();
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void drawNewBees(Graphics g) {
			for(int i = 0; i < Krolowa.watki.size() - Main.N - 1; i++) {
					if(newbees.get(i).isVisible())
						g.drawImage(newbees.get(i).getImage(), newbees.get(i).getX(), newbees.get(i).getY(), this);
		}	
	}

	private void drawFirstBees(Graphics g) {
		for(int i = 0; i < Main.N; i++) {
			if(bees.get(i).isVisible())
				g.drawImage(bees.get(i).getImage(), bees.get(i).getX(), bees.get(i).getY(), this);
		}	
	}

	public static void newBees(int birthRate) {
		for(int i = 0; i < birthRate; i++) {
				Bee bee = new Bee(660, 30 + 70 * i);
				bee.setVisible(false);
				newbees.add(bee);
		}
		
	}
}
