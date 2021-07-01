package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class InvisWallL extends GameObject{
	
	private Handler handler;
	
	public InvisWallL(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}
	public void tick() {
		
	}
	public Rectangle getBounds() {
		return new Rectangle((int)0, (int)0, 1, 480);
	}
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		//g.setColor(Color.orange);
		//g2d.draw(getBounds());
	}
}