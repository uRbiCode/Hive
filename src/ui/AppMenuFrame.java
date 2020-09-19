package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import app.Main;
import constants.Constants;
import image.Image;
import image.ImageFactory;

public class AppMenuFrame extends JFrame implements ActionListener {
	
	JButton plusK = new JButton();
	JButton minusK = new JButton();
	JButton plusN = new JButton();
	JButton minusN = new JButton();
	JButton plusX = new JButton();
	JButton minusX = new JButton();
	JButton play = new JButton();
	
	JLabel K = new JLabel(String.valueOf(Main.K));
	JLabel N = new JLabel(String.valueOf(Main.N));
	JLabel X = new JLabel(String.valueOf(Main.zyciePszczoly));
	JLabel Kinfo = new JLabel("Liczba miejsc w ulu");
	JLabel Ninfo = new JLabel("Liczba pszczó³");
	JLabel Xinfo = new JLabel("D³ugoœæ ¿ycia pszczó³");
	
	public AppMenuFrame(){
		initializeLayout();
	}
	
	private void initializeLayout() {
		
		setTitle(Constants.TITLE);
		setIconImage(ImageFactory.createImage(Image.BEELEFT).getImage());
		
		setLayout(null);		
		
		Kinfo.setBounds(195, 170, 1000, 100);
		Ninfo.setBounds(212, 320, 1000, 100);
		Xinfo.setBounds(190, 470, 1000, 100);
		
		add(Kinfo);
		add(Ninfo);
		add(Xinfo);
		
		plusK.setBounds(325, 200, 100, 100);
		minusK.setBounds(75, 200, 100, 100);
		plusN.setBounds(325, 350, 100, 100);
		minusN.setBounds(75, 350, 100, 100);;
		plusX.setBounds(325, 500, 100, 100);
		minusX.setBounds(75, 500, 100, 100);
		play.setBounds(125, 50, 250, 100);
		
		plusK.setFont(new Font("Arial", Font.PLAIN, 40));
		plusK.setText("+");
		plusN.setFont(new Font("Arial", Font.PLAIN, 40));
		plusN.setText("+");
		plusX.setFont(new Font("Arial", Font.PLAIN, 40));
		plusX.setText("+");
		minusK.setFont(new Font("Arial", Font.PLAIN, 40));
		minusK.setText("-");
		minusN.setFont(new Font("Arial", Font.PLAIN, 40));
		minusN.setText("-");
		minusX.setFont(new Font("Arial", Font.PLAIN, 40));
		minusX.setText("-");
		play.setFont(new Font("Arial", Font.PLAIN, 40));
		play.setText("Start");
		
		plusK.addActionListener(this);
 		minusK.addActionListener(this);
 		plusN.addActionListener(this);
 		minusN.addActionListener(this);
 		plusX.addActionListener(this);
 		minusX.addActionListener(this);
 		play.addActionListener(this);
		
		add(plusK);
		add(minusK);
		add(plusN);
		add(minusN);
		add(plusX);
		add(minusX);
		add(play);
		
		
		K.setFont(new Font("Arial", Font.PLAIN, 40));				
		N.setFont(new Font("Arial", Font.PLAIN, 40));
		X.setFont(new Font("Arial", Font.PLAIN, 40));
		
		K.setBounds(240, 200, 100, 100);
		N.setBounds(230, 350, 100, 100);
		X.setBounds(230, 500, 100, 100);
		
		add(K);
		add(N);
		add(X);
		
		setSize(500, 700);		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
	}
	
 	@Override
 	public void actionPerformed(ActionEvent e) {
 		if(e.getSource() == plusK) {
 			Main.K++;
 			if(Main.K * 2 >= Main.N) Main.K--;
 			K.setText(String.valueOf(Main.K));
 			this.setFocusable(true);
 		}
 		if(e.getSource() == minusK) {			
 			Main.K--;
 			if(Main.K < 1) Main.K = 1;
 			K.setText(String.valueOf(Main.K));
 			this.setFocusable(true);
 		}
 		if(e.getSource() == plusN) {
 			Main.N++;
 			if(Main.N > 10) Main.N = 10;
 			N.setText(String.valueOf(Main.N));
 			if(Main.N == 10) {
 				N.setBounds(230, 350, 100, 100);
 			}
 			else N.setBounds(240, 350, 100, 100);
 			this.setFocusable(true);
 		}
 		if(e.getSource() == minusN) {
 			Main.N--;
 			if(Main.N < 1) Main.N = 1;
 			if(Main.K * 2 >= Main.N) {
 				Main.K--;
 				if(Main.K == 0) Main.K = 1;
 				K.setText(String.valueOf(Main.K)); 				
 			}
 			N.setText(String.valueOf(Main.N));
 			if(Main.N == 10) {
 				N.setBounds(230, 350, 100, 100);
 			}
 			else N.setBounds(240, 350, 100, 100);
 			this.setFocusable(true);
 		}
 		if(e.getSource() == plusX) {
 			Main.zyciePszczoly++;
 			if(Main.zyciePszczoly > 10) Main.zyciePszczoly = 10;
 			X.setText(String.valueOf(Main.zyciePszczoly));
 			if(Main.zyciePszczoly == 10) {
 				X.setBounds(230, 500, 100, 100);
 			}
 			else X.setBounds(240, 500, 100, 100);
 			this.setFocusable(true);
 		}
 		if(e.getSource() == minusX) {
 			Main.zyciePszczoly--;
 			if(Main.zyciePszczoly < 1) Main.zyciePszczoly = 1;
 			X.setText(String.valueOf(Main.zyciePszczoly));
 			if(Main.zyciePszczoly == 10) {
 				X.setBounds(230, 500, 100, 100);
 			}
 			else X.setBounds(240, 500, 100, 100);
 			this.setFocusable(true);
 		}
 		if(e.getSource() == play) {
 			this.setVisible(false);
 			Main.menu = false;
 		}
 	}
 }
