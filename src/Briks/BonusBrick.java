package Briks;

//package bricks;

import java.awt.Image;
import java.awt.Rectangle;

class BonusBrick extends Brick {
	/*
	 * @_hitCount - количество допустимых ударов шайбой
	 *            кирпич разрушается, как только атрибут
	 * 			  будет равен нулю
	 * @_woundImg - изображение поврежденого кирпича
	 * 			  заменяет исходное изображение при первом
	 * 			  ударе шайбы
	 */
	 

	public BonusBrick(
		PlayField pf,
		BrickPile bp,
		Rectangle p,
		Image img) {
			super(pf, bp, img, p);
		}
		
	public void hitBy(Puck p) {
        super.hitBy(p);
        var fallingball = new FallingBall(_pf, Match._ps, Match._lib[6], new Vector2(_pos.x, _pos.y));
        Match._pf.addSprite(fallingball);
	}
}
