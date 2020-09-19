package representation;

import javax.swing.ImageIcon;

import app.Main;
import image.Image;
import image.ImageFactory;
import model.Krolowa;
import ui.AppPanel;

public class Bee extends Sprite {
	
	private boolean visible = true;
	
	public Bee(int x, int y) {
		this.x = x;
		this.y = y;
		initialize();
	}

	private void initialize() {		
		ImageIcon imageIcon = ImageFactory.createImage(Image.BEELEFT);
		setImage(imageIcon.getImage());
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public void move(int place, int id) {
		if(place == 1) {
			this.setX(100);
			this.setY(240);
		}	
		if(place == 2) {
			this.setX(200);
			this.setY(240);
		}			
		if(place == 3) {
			this.setX(100);
			this.setY(450);
		}			
		if(place == 4) {
			this.setX(200);
			this.setY(450);
		}			
		if (place == 0) {
			if(id < 11) {
				this.setX(720);
				this.setY(30 + 70 * (id - 1));
			}
			else {
				this.setX(660);
				this.setY(30 + 70 * ((id - 1) % 10));
			}
		}		
	}
	
	@Override
	public void move() {
		
	}

}
