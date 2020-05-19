
package Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class MyButton extends JButton implements Observer {
    private Counter counter;
    private MyPanel panel;

    public MyButton(Counter counter, MyPanel panel, int change) {
        if (change == 1) {
            this.setText("Add");
        } else {
            this.setText("Substract");
        }

        if (change == 1) {
            MyButtonListener listener = new MyButtonListener();
            this.addActionListener(listener);
        } else {
            SubstractListener listener = new SubstractListener();
            this.addActionListener(listener);
        }

        this.counter = counter;
        this.panel = panel;
    }

    public void update(Observable o, Object arg) {
        panel.setStr(panel.counter.getCounter());
        panel.repaint();
    }

    private class MyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Main.Global.setVisible(false);
            Main.Global.dispose();
        }
    }
    private class SubstractListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            panel.counter.decrement();
        }
    }
}
