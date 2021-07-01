package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.Game.STATE;
import main.Game;

public class HUD {

	private Handler handler;
	
	public void tick() {
		
	}

	public Rectangle getBounds() {
		return null;
	}
	public void render(Graphics g) {
	g.setColor(Color.white);
	g.fillRect(304, 0, 10, 40);
	g.fillRect(304, 50, 10, 40);
	g.fillRect(304, 100, 10, 40);
	g.fillRect(304, 150, 10, 40);
	g.fillRect(304, 200, 10, 40);
	g.fillRect(304, 250, 10, 40);
	g.fillRect(304, 300, 10, 40);
	g.fillRect(304, 350, 10, 40);
	g.fillRect(304, 400, 10, 40);
	}
}
