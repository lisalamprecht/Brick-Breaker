import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.security.Key;

import javax.imageio.ImageIO;
import javax.swing.*;


/**
 * This is for using key bindings so I can read the key inputs required for game
 * play
 */
public class MotionAction extends AbstractAction implements ActionListener {
    //Global Variables
    private JComponent component;
    private int deltaX;
    private int deltaY;
    private InputMap inputMap;

    //constructor
    MotionAction(JComponent component) {
        this.component = component;
        //component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW); 
    }

    public void addAction(String keyInputName, int keyDeltaX, int keyDeltaY)
    {
        component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW); 
        component.getInputMap().put(KeyStroke.getKeyStroke(keyInputName), keyInputName);   
        component.getActionMap().put(keyInputName, new MotionAction(component));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    




}
    

