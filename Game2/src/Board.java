import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Board extends JPanel {
    BufferedImage bgImg;
    Player player;
    Enemy_2 enemy;
    Timer timer;
    Enemy_2 enemies[];

    public Board() {
        showBg();
        player = new Player();
//        enemy = new Enemy();
        enemies = new Enemy_2[3];
        loadEnemies();
        gameLoop();
        setFocusable(true);
        bindEvents();
   }

    public void showBg() {
        URL image = Board.class.getResource("gamebg.jpg");
        try {
            bgImg = ImageIO.read(image);
        } catch (IOException e) {
            System.out.println("Error reading the file ganebg.jpg");
            e.printStackTrace();
        }
    }
    private void gameLoop(){
        timer = new Timer(30 , (e) -> repaint());
        timer.start();
    }
    
    private void loadEnemies() {
    	int i_X = 500;
    	int speed = 2;
    	int gap = 150;
    	for(int i = 0;i<enemies.length;i++) {
    		enemies[i] = new Enemy_2(i_X , speed);
    		i_X += 250;
    		speed += 2;
    	}
    }
    
    private void bindEvents() {
    	addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
				player.speed = 0;
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					player.speed = 3;
					if(player.x == 1150) {
						gameWin(getGraphics());
					}
				}
				else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.speed = -3;
				}
				
			}
		});
    }
    
    private void gameWin(Graphics brush) {
		brush.setFont(new Font("times", Font.BOLD , 150));
		brush.setColor(Color.RED);
		brush.drawString("Game Win", 200, 220);
		timer.stop();
	}
    private void paintEnemies(Graphics brush) {
    	for(Enemy_2 enemy_iterator : enemies) {
    		enemy_iterator.draw(brush);
    		enemy_iterator.move();
    	}
    }

    public void paintComponent(Graphics brush) {
        super.paintComponent(brush);
        brush.drawImage(bgImg, 0, 0, 1200, 600, null);
        player.draw(brush);
        player.move();
        paintEnemies(brush);
//        enemy.draw(brush);
//        enemy.move();
    }
}




