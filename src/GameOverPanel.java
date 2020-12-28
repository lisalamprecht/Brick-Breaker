import java.awt.Color;
import java.util.*;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.*;


import java.awt.event.*;

public class GameOverPanel extends JPanel {
    //Global Variables
    private int width;
    private int height; 
    private KeyBindings kBindings;
    
    GameOverPanel(int gamePanelWidth, int gamePanelHeight) {
        this.setWidth(gamePanelWidth);
        this.setHeight(gamePanelHeight);
        this.isVisible();

        initialise();
    }

    private void initialise() {
        kBindings = new KeyBindings();
        JPanel helperPanel1 = new JPanel();
        JPanel helperPanel2 = new JPanel();
        
        JLabel gameOverLabel = new JLabel("Game Over!", SwingConstants.CENTER); //swings centers the text
        JLabel label = new JLabel("Home (esc); Play Again (space)", SwingConstants.CENTER);
        this.setLayout(new GridLayout(0,1));
        
        
        gameOverLabel.setFont(new Font("Verdana", Font.PLAIN, 40));
        gameOverLabel.setForeground(Color.RED); //changes text color
        label.setForeground(Color.WHITE);

        helperPanel1.setLayout(new BorderLayout());
        helperPanel2.setLayout(new BorderLayout());

        helperPanel1.add(gameOverLabel, BorderLayout.SOUTH); //add label to panel placing it in the south point of the panel
        helperPanel2.add(label, BorderLayout.NORTH); //places label in north point of panel
        helperPanel2.setBackground(Color.BLACK);
        helperPanel1.setBackground(Color.BLACK);

        this.add(helperPanel1);
        this.add(helperPanel2);

        //initialise key bindings for space, left and right
        kBindings.addKeyBinding(this, KeyEvent.VK_SPACE, "playAgain", (evt) -> {
            JPanel parent = (JPanel)getParent();
            CardLayout layout = (CardLayout)parent.getLayout();
            layout.show(parent, "Game Panel"); //changes the panel shown to the one called "Game Panel"
        });
        kBindings.addKeyBinding(this, KeyEvent.VK_ESCAPE, "home", (evt) -> {
            JPanel parent = (JPanel)getParent();
            CardLayout layout = (CardLayout)parent.getLayout();
            layout.show(parent, "Home"); //changes the panel shown to the one called "Game Panel"
        });
       
        
    }

     // paint all the elements in
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // background
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
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
