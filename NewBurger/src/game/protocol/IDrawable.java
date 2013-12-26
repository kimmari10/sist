package game.protocol;

import java.awt.Graphics;

public interface IDrawable { 
	void move(int maxY);
	void paint(Graphics g);
	int getY();
}
