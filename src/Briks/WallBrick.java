package Briks;

import java.awt.Image;
import java.awt.Rectangle;

public class WallBrick extends Brick {
    public WallBrick(PlayField pf, BrickPile bp, Image img, Rectangle p) {
        super(pf, bp, img, p);
    }
    
    @Override
    public void hitBy(Puck p) {
        super.hitBy(p);
        _isDead = false;
        System.out.println("Unkillable one");
	}
}