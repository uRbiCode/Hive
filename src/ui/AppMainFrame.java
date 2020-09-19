package ui;

import javax.swing.JFrame;
import constants.Constants;
import image.Image;
import image.ImageFactory;

public class AppMainFrame extends JFrame {

	public AppMainFrame(){
		initializeLayout();
	}

	private void initializeLayout() {
		
		add(new AppPanel());
		
		setTitle(Constants.TITLE);
		setIconImage(ImageFactory.createImage(Image.BEELEFT).getImage());
		
		pack();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
	}
}
