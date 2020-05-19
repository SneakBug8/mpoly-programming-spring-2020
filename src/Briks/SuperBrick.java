package Briks;

import java.awt.Image;
import java.awt.Rectangle;

public class SuperBrick extends Brick {
    public SuperBrick(PlayField pf, BrickPile bp, Image img, Rectangle p) {
		super(pf, bp, img, p);
    }
    
    @Override
    public void hitBy(Puck p) {
        p._v.SetSpeed(p._v.getSpeed() + 2);

        System.out.println(p._v.getSpeed());
        super.hitBy(p);
	}
}