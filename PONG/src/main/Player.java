package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends GameObject{

	Handler handler;
	int score = 0;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}
	public void tick() {
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 50);
		y = Game.clamp(y, 0, Game.HEIGHT - 140);
	}
	public void count() {
		score++;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 100);
	}
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.white);
		g.fillRect(x, y, 16, 100);
		//g.setColor(Color.BLUE);
		//g2d.draw(getBounds());
	}
}