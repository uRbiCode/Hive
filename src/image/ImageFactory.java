package image;

import javax.swing.ImageIcon;

import constants.Constants;

public class ImageFactory {
	
	public static ImageIcon createImage(Image image) {
		
		ImageIcon imageIcon = null;
		
		switch(image) {
		case BACKGROUND:
			imageIcon = new ImageIcon(Constants.BACKGROUND_IMAGE_URL);
			break;
			
		case QUEEN:
			imageIcon = new ImageIcon(Constants.QUEEN_IMAGE_URL);
			break;
			
		case HIVE:
			imageIcon = new ImageIcon(Constants.HIVE_IMAGE_URL);
			break;
			
		case BEELEFT:
			imageIcon = new ImageIcon(Constants.BEELEFT_IMAGE_URL);
			break;
			
		case BEERIGHT:
			imageIcon = new ImageIcon(Constants.BEERIGHT_IMAGE_URL);
			break;
			
		default:
			return null;
		}
		return imageIcon;
	}
}
