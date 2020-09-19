package ui;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class AppLoop implements ActionListener {
	private AppPanel appPanel;
	
	public AppLoop(AppPanel appPanel) {
		this.appPanel = appPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.appPanel.doOneLoop();
	}
}