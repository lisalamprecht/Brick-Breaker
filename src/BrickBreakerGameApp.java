import java.awt.CardLayout;
import javax.swing.JPanel;

public class BrickBreakerGameApp {

    public BrickBreakerGameApp() {
        int pw = 500;
        int ph = 900;
        GamePanel gPanel = new GamePanel(pw,ph);
        GameOverPanel oPanel = new GameOverPanel(pw,ph);
        Home home = new Home(pw,ph);

        //create the panel that contains the `cards`
        JPanel panelCont = new JPanel();
        CardLayout cLayout = new CardLayout();
        panelCont.setLayout(cLayout);
        panelCont.add(gPanel, "Game Panel");
        panelCont.add(oPanel, "Game Over Panel");
        panelCont.add(home, "Home");
        cLayout.show(panelCont, "Home");

        GameFrame gFrame = new GameFrame();
       
        gFrame.getContentPane().add(panelCont); //add game panel container to frame

        gFrame.pack();
        gFrame.setVisible(true); //make frame visible
    }
    public static void main(String[] args) {
        new BrickBreakerGameApp();
    }
}
