package Convex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class MyButton extends JButton implements Observer {

    public MyButton() {
        MyButtonListener listener = new MyButtonListener();
        this.addActionListener(listener);
    }

    public void update(Observable o, Object arg) {
    }

    private class MyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ConvexWindow.Global.setVisible(false);
            ConvexWindow.Global.dispose();
        }
    }
}