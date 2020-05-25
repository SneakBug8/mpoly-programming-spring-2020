package Briks;

//package bricks;

import java.awt.Frame;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Match {
	private Frame _top;
	public static PuckSupply _ps;
	public static BrickPile _bp;
	public static PlayField _pf;
	private MediaTracker _tracker;
	public static Image[] _lib;
	private String _message = "";

	public Match() {
		_top = new Frame("Bricks");
		_pf = new PlayField(this);
		_tracker = new MediaTracker(_pf);
		_lib = new Image[8];
		_lib[0] = _pf.getToolkit().getImage("src/Briks/puck.gif");
		_lib[1] = _pf.getToolkit().getImage("src/Briks/puddle.gif");
		_lib[2] = _pf.getToolkit().getImage("src/Briks/brick.gif");
		_lib[3] = _pf.getToolkit().getImage("src/Briks/wallbrick.gif");
		_lib[4] = _pf.getToolkit().getImage("src/Briks/superbrick.gif");
		_lib[5] = _pf.getToolkit().getImage("src/Briks/hardbrick.gif");
		_lib[6] = _pf.getToolkit().getImage("src/Briks/fallingball.gif");
		_lib[7] = _pf.getToolkit().getImage("src/Briks/bonusbrick.png");


		_tracker.addImage(_lib[0], 0);
		_tracker.addImage(_lib[1], 0);
		_tracker.addImage(_lib[2], 0);
		_tracker.addImage(_lib[3], 0);
		_tracker.addImage(_lib[4], 0);
		_tracker.addImage(_lib[5], 0);
		_tracker.addImage(_lib[6], 0);
		_tracker.addImage(_lib[7], 0);


		MenuBar mbar = new MenuBar();
		_top.setMenuBar(mbar);

		Menu file = new Menu("Game");
		MenuItem i1, i2, i3, i4;
		file.add(i1 = new MenuItem("start"));
		file.add(i2 = new MenuItem("pause"));
		file.add(i3 = new MenuItem("resume"));
		file.add(i4 = new MenuItem("exit"));

		mbar.add(file);
		_top.setSize(600, 400);

		i1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
    
		i2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_pf.stop();
			}
		});
    
		i3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_pf.start();
			}
		});
    
		i4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
    
		_top.add("Center", _pf);
		_top.show();
	}

	public void start() {
		try {
			_tracker.waitForID(0);
		} catch (InterruptedException e) {
			return;
		}
		
		_message = "";
		_pf.clean();
    
		_bp = new BrickPile(_pf, _lib[2]);
		_ps = new PuckSupply(3, _pf, _lib[0]);
   
		_pf.addSprite(new Puddle(_pf,_lib[1]));
		_pf.addSprite(_ps.get());
    
		_pf.start();
	}

	public void loose() {
		_message = "You Loose";
		_pf.repaint();
		_pf.stop();
	}

	public void win() {
		_message = "You win";
		_pf.repaint();	
		_pf.stop();
	}

	public static void main(String[] args) {
		Match m = new Match();
	} 
  
	public String getMessage() {
		return _message;
	}
}