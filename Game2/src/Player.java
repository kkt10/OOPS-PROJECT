

import javax.swing.ImageIcon;

public class Player extends Sprites {

public Player(){
	x=10;
	y=300;
	height= 100;
	width = 100;
	speed = 5;
	image = new ImageIcon(Player.class.getResource("dude.gif"));
}

	
	public void move() { 
	if(x>1200){
	x=10;
	}
		x= x+ speed;
		}
	}

