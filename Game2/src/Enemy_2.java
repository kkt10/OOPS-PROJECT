
import javax.swing.ImageIcon;

public class Enemy_2 extends Sprites {

	

public Enemy_2(int new_x,int updated_speed){
	x=550;
	y=10;
	height= 100;
	width = 100;
	speed = 5;
	this.x=new_x;
	this.speed =updated_speed;
	image = new ImageIcon(Enemy_2.class.getResource("Enemy.gif"));
}
	
	
	public void move() {
if(y>500) {
	y=10;
}
		y= y+ speed;
		}
	
}




