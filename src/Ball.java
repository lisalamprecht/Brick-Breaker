import java.awt.Color;
import java.awt.color.*;
import java.awt.*;
import javax.swing.*;

public class Ball {
    //Global Variables
    private int ballWidth;
    private int ballHeight;
    private int ballX; //for ball X Y location
    private int ballY;
    private Color ballColor = Color.MAGENTA;
    private GamePanel gamePanel;
    

    //Create ball constructor
    Ball() {
        
    }

    //create ball constructor based off parameters
    Ball(int bX, int bY, int bWidth, int bHeight, GamePanel gPanel) {
        //set the values
        this.setBallWidth(bWidth);
        this.setBallHeight(bHeight);
        this.setBallX(bX);
        this.setBallY(bY);
        this.setGamePanel(gPanel);
    }

    //create get and set methods for all attributes of the ball
    public int getBallWidth() {
        return ballWidth;
    }

    public void setBallWidth(int bWidth) {
        this.ballWidth = bWidth;
    }

    public int getBallHeight() {
        return ballHeight;
    }

    public void setBallHeight(int bHeight) {
        this.ballHeight = bHeight;
    }

    public int getBallX() {
        return ballX;
    }

    public void setBallX(int bX) {
        this.ballX = bX;
    }

    public int getBallY() {
        return ballY;
    }

    public void setBallY(int bY) {
        this.ballY = bY;
    }

    public Color getBallColor() {
        return ballColor;
    }

    public void setBallColor(Color bColor) {
        this.ballColor = bColor;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gPanel) {
        this.gamePanel = gPanel;
    }
    
}
