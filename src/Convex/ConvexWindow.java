package Convex;

import javax.swing.*;
import java.awt.*;

public class ConvexWindow extends JFrame {

    public static final int width = 600;
    public static final int height = 600;
    private Convex convex;


    public ConvexWindow(Convex convex){
        this.setTitle("ConvexWindow");
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.convex = convex;
    }

    public void add(){
        this.update(this.getGraphics());
    }

    @Override
    public void paint(Graphics g){
        g.translate(width/2,height/2);
        g.drawLine(-width/2, 0, height/2, 0);
        g.drawLine(0, -width/2, 0, height/2);

        convex.draw(g);
    }
}
