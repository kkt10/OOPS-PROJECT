
import javax.swing.JFrame;
public class Frame {

	Frame() {
        // Create the frame.
        JFrame frame = new JFrame();
        frame.setSize(1200, 600);
        frame.setTitle("Game");
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Board());
    }

    public static void main(String[] args) {
    	Frame obj = new Frame();
    	
    }
}

