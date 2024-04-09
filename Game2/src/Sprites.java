import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Sprites {

	int x,  y, height , width;
	 int speed;
	ImageIcon image;
	

public void draw(Graphics brush){
	brush.drawImage(image.getImage(),x, y, width,height, null);
}
}
