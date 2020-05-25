package Briks;

//package bricks;

import java.awt.Image;
import java.awt.Rectangle;

/* Шайба */

class FallingBall extends Puck {

	public FallingBall(PlayField pf, PuckSupply ps, Image img, Vector2 pos) {
		super(pf, ps, img);

		_pos = new Rectangle(pos.x, pos.y, img.getWidth(pf), img.getHeight(pf));
		_v.SetSpeed(4);

		_isMoving = true;
		_isDead = false;
	}

	public void move() {
		if (!_isMoving)
			return;

		Rectangle b = _pf.getBoundary();

		_prevPos = _pos;
		_pos.translate(_v.getSpeedX(), _v.getSpeedY());

		/* Oбработка соударения со стенами, полом и потолком. */
		if (_pos.y + _pos.height > b.y + b.height) {
			/* Шайба упала на пол */
			_pf.getMatch().loose();
		}

		if (collideWith() != null) {
			collideInto(collideWith());
		}
	}

	public void collideInto(Sprite s) {
		if (s.getClass() == Puddle.class) {
			System.out.println("1111");
			s.hitBy(this);
		}
	}

	public void hitBy(Puck p) {
		;
	}
}