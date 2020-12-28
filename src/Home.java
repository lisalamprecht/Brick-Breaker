import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.awt.event.*;

public class Home extends JPanel{
    //Global Variables
    private int width;
    private int height; 
    private KeyBindings kBindings;

    Home(int gamePanelWidth, int gamePanelHeight) {
        this.setWidth(gamePanelWidth);
        this.setHeight(gamePanelHeight);
        this.isVisible();

        initialise();
    }

    private void initialise() {
        kBindings = new KeyBindings();
        JPanel helperPanel1 = new JPanel();
        JPanel helperPanel2 = new JPanel();
        
        JLabel brickBreakerLabel = new JLabel("Brick Breaker!", SwingConstants.CENTER); //swings centers the text
        JLabel label = new JLabel("Play (space); Exit Game (esc)", SwingConstants.CENTER);
        this.setLayout(new GridLayout(0,1));
        
        brickBreakerLabel.setFont(new Font("Verdana", Font.BOLD, 40));
        brickBreakerLabel.setForeground(Color.ORANGE); //changes text color
        label.setForeground(Color.WHITE);

        helperPanel1.setLayout(new BorderLayout());
        helperPanel2.setLayout(new BorderLayout());

        helperPanel1.add(brickBreakerLabel, BorderLayout.SOUTH); //add label to panel placing it in the south point of the panel
        helperPanel2.add(label, BorderLayout.NORTH); //places label in north point of panel
        helperPanel2.setBackground(Color.BLACK);
        helperPanel1.setBackground(Color.BLACK);

        this.add(helperPanel1);
        this.add(helperPanel2);

        //initialise key bindings for space, left and right
        kBindings.addKeyBinding(this, KeyEvent.VK_SPACE, "play", (evt) -> {
            JPanel parent = (JPanel)getParent();
            CardLayout layout = (CardLayout)parent.getLayout();
            layout.show(parent, "Game Panel"); //changes the panel shown to the one called "Game Panel"
        });
        kBindings.addKeyBinding(this, KeyEvent.VK_ESCAPE, "exit", (evt) -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this); //get the frame of this panel
            frame.dispose();
        });
    }

    // create get and set methods for all panel attributes
    public int getWidth() {
        return width;
    }

    public void setWidth(int pWidth) {
        this.width = pWidth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int pHeight) {
        this.height = pHeight;
    }
    
}
