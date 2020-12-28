import java.awt.Color;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import java.util.*;
import java.awt.*;

/**
 * This class handles the game panel as a whole
 */

public class GamePanel extends JPanel implements ActionListener {

    // Global Variables
    private Ball ball;
    private Paddle paddle;
   // private Bricks bricks;
    private GameFrame gameFrame;
    private int width;
    private int height; 
    private Timer timer;
    private int brickHeight = 30;
    private int brickWidth = 60;
    ArrayList<Bricks> brickArray = new ArrayList<Bricks>();
    int brickCount;
    int leftOverSpace;
    private int ballXDir = -1;
    private int ballYDir = -2;
    private boolean play = false;
    private int delay = 8;
    private KeyBindings kBindings;

    // create a constructor
    GamePanel (int gamePanelWidth, int gamePanelHeight) {
        this.setWidth(gamePanelWidth);
        this.setHeight(gamePanelHeight);
        
        initialiseGame();
        this.isVisible();
    }

    private void initialiseGame() {
        play = false;
        ball = new Ball(10, 520, 30, 30, this); //create the ball object
        paddle = new Paddle(this, 50, 700, 100, 10); //creates paddle object
        initialiseBrickArray();
        kBindings = new KeyBindings();
        
        //Set up timer to drive animation events.
        timer = new Timer(delay, this);

        //initialise key bindings for space, left and right
        kBindings.addKeyBinding(this, KeyEvent.VK_SPACE, "startBall", (evt) -> {
            play = true;
        });
        kBindings.addKeyBinding(this, KeyEvent.VK_LEFT, "moveLeft", (evt) -> {
            paddle.moveLeft();
        });
        kBindings.addKeyBinding(this, KeyEvent.VK_RIGHT, "moveRight", (evt) -> {
            paddle.moveRight();
        }); 
        
        //this will make the ball move continuously if play is true (every 5 milisec)
        Timer t = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(play) {
                    startBall(play);
                }
            }
        });
        t.start();
    }

     //starts the ball moving
     private void startBall(boolean play) {
        if(play) { //if play is true start moving the ball
            //need to detect whether the ball is touching the left/right/top borders and move accordingly
            ball.setBallX(ball.getBallX()+ballXDir);
            ball.setBallY(ball.getBallY()+ballYDir);
            if(ball.getBallX() <= 0 || ball.getBallX() > this.getWidth() - ball.getBallWidth()) { //left and right border
                ballXDir = -ballXDir; //reverse horizontal direction
            }
            if(ball.getBallY() < 0 || ball.getBallY() > this.getHeight() - ball.getBallHeight()) { //top border
                ballYDir = -ballYDir; //reverse vertical direction
            }

            //check for collision using new rectangles based off currenct ball/paddle coordinates to enable use of .intersects
            if(
                new Rectangle( ball.getBallX(), ball.getBallY(), ball.getBallWidth(), ball.getBallHeight() )
                .intersects( new Rectangle( paddle.getPaddleX(), paddle.getPaddleY(), paddle.getPaddleWidth(), paddle.getPaddleHeight() ) ) ) 
            {
                ballYDir = -ballYDir; //reverse vertical direction
            }

            //check for brick collision
            //changes ball y direction if it hits a visible brick
            //if a visible brick is hit, it's visibility is set to false
            for(Bricks bricks: brickArray) {
                if( new Rectangle( ball.getBallX(), ball.getBallY(), ball.getBallWidth(), ball.getBallHeight() )
                .intersects( new Rectangle( bricks.getBrickX(), bricks.getBrickY(), bricks.getBrickWidth(), bricks.getBrickHeight() ) ) 
                && bricks.getVisible())
                {
                    ballYDir = -ballYDir;
                    bricks.setVisible(false);
                }
            } 

            //reinitialises game if they miss hitting the ball
            if(ball.getBallY() > paddle.getPaddleY() ) {
                initialiseGame();
                JPanel parent = (JPanel)getParent();
                CardLayout layout = (CardLayout)parent.getLayout();
                layout.show(parent, "Game Over Panel"); //changes the panel shown to the one called "Game Panel"
            }

        }
        this.repaint(); 
    }

    //creates the array list of brick objs
    private void initialiseBrickArray() {
        int spacing = 4;
        brickRowCount();
        int startPoint = leftOverSpace / 2; //so that the bricks are centered
        for(int y=startPoint; y < 4*(brickHeight + spacing); y=y+brickHeight+spacing) { //y axis
            for(int x=startPoint; x<(brickWidth + 4)*brickCount; x=x+brickWidth+4) { //x axis
                brickArray.add(new Bricks(x + 4, y + 4, brickWidth, brickHeight, true)); //creates the bricks object and adds brick to the brickArray
            }
        }
    }

    //counts the number of bricks that will fit on the screen
    private void brickRowCount() {
        boolean b = true;
        int width = 0;
        brickCount = 0;
        while(b == true) {
            if((width + 4 + brickWidth) < this.getWidth()) {
                width = width + brickWidth + 4;
                brickCount++;
            }
            else {
                b = false;
            }
        }
        leftOverSpace = this.getWidth() - width;
    }

    //maps the input and then the action. Uses action listener to decide what action is performed 
   /* public void addKeyBinding(JComponent comp, int keyCode, String id, ActionListener actionListener) {
                InputMap im = comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
                ActionMap ap = comp.getActionMap();

                im.put(KeyStroke.getKeyStroke(keyCode, 0, false), id);
                ap.put(id, new AbstractAction() {
        
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        actionListener.actionPerformed(e);
                    }
                });
    }*/

    
    // paint all the elements in
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // background
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());

        // paddle
        g.setColor(Color.CYAN);
        g.fillRect(paddle.getPaddleX(), paddle.getPaddleY(), paddle.getPaddleWidth(), paddle.getPaddleHeight());

        // ball
        g.setColor(Color.MAGENTA);
        g.fillOval(ball.getBallX(), ball.getBallY(), ball.getBallWidth(), ball.getBallHeight());

        for(Bricks bricks: brickArray) {
            // brick
            if(bricks.getVisible() == true) { //only paint the visible bricks
                g.setColor(Color.GREEN);
                g.fillRect(bricks.getBrickX(), bricks.getBrickY(), bricks.getBrickWidth(), bricks.getBrickHeight());
            }   
        } 
    }

    //create get and set methods for all panel attributes
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

    //only here because of the implements listeners for the class for the timer
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    
}
