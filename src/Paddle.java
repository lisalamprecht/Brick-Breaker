import javax.swing.AbstractAction;

import java.awt.event.*;

public class Paddle {
    //Global Variables
    private int paddleWidth;
    private int paddleHeight;
    private int paddleX; //paddle x position
    private int paddleY;
    private GamePanel gamePanel;
    
    //create paddle constructor
    Paddle() {

    }

    //create a paddle constructor based off parameters
    Paddle(GamePanel gPanel, int pX, int pY, int pWidth, int pHeight) {
        //set the values
        this.setPaddleWidth(pWidth);
        this.setPaddleHeight(pHeight);
        this.setPaddleX(pX);
        this.setPaddleY(pY);
        this.setGamePanel(gPanel);

    }

    //create get and set methods for all paddle attributes
    public int getPaddleWidth() {
        return paddleWidth;
    }

    public void setPaddleWidth(int pWidth) {
        this.paddleWidth = pWidth;
    }

    public int getPaddleHeight() {
        return paddleHeight;
    }

    public void setPaddleHeight(int pHeight) {
        this.paddleHeight = pHeight;
    }

    public int getPaddleX() {
        return paddleX;
    }

    public void setPaddleX(int pX) {
        this.paddleX = pX;
    }

    public int getPaddleY() {
        return paddleY;
    }

    public void setPaddleY(int pY) {
        this.paddleY = pY;
    }

    
    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gPanel) {
        this.gamePanel = gPanel;
    }

    //move the paddle left if it is not already positoned at 0 (far left)
    public void moveLeft() {
        try {
            if(getPaddleX() <= 0) {
                setPaddleX(0);
                System.out.println("less than 0, x: " + getPaddleX());
                
            } 
            else if (getPaddleX() > 0) {
                setPaddleX(getPaddleX()-10); //to move paddle left -10
          //      gamePanel.repaint(getPaddleX()+10, getPaddleY(), getPaddleWidth(), getPaddleHeight()); //repaint old position
          //      gamePanel.repaint(getPaddleX(), getPaddleY(), getPaddleWidth(), getPaddleHeight()); //repaint new position
                System.out.println("left, x: " + getPaddleX());
              
            }

            gamePanel.repaint();
            
            
        }
        catch (Exception e) {
            
         }
        

    }

    

    //move the paddle right if it is not already positioned to the far right of the panel
    public void moveRight() {
        
        if(getPaddleX() >= gamePanel.getWidth() - getPaddleWidth()) { //dont move the paddle if it is on the right edge of the panel
            setPaddleX(gamePanel.getWidth() - getPaddleWidth());
            System.out.println("right1, x:" + getPaddleX());
            
        }
        else if ((getPaddleX()+getPaddleWidth()) <= gamePanel.getWidth()){ //if the paddle is within the panel bounds
            setPaddleX(getPaddleX() + 10); //to move paddle right +10
            System.out.println("right, x:" + getPaddleX());
        }

        gamePanel.repaint();
        
    }
}
