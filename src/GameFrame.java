import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameFrame extends JFrame {
    //Global Variables
    public int frameWidth = 500;
    public int frameHeight = 800;
    
    //create constructor
    GameFrame () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //so app closes properly
        this.setPreferredSize(new Dimension(frameWidth, frameHeight)); //set frame size
        this.setTitle("Brick Breaker Game");

        ImageIcon icon = new ImageIcon("res/brick-breaker-logo.jpg"); //create image icon
        this.setIconImage(icon.getImage()); //update frame icon

        this.pack();
    }
}
