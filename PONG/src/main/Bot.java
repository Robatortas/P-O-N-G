package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Bot extends GameObject{
	
	private Handler handler;
	private GameObject ball;
	int score = 0;
	
	public Bot(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
			
			velY = 5;
		}
	public void tick() {
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH);
		y = Game.clamp(y, 0, Game.HEIGHT - 140);
		
		for(int i = 0; i < handler.object.size(); i++) {
			if(handler.object.get(i).getID() == ID.Ball) ball = handler.object.get(i);
		}
		
		float diffX = x - ball.getX() - -50;
		float diffY = y - ball.getY() - -50;
		float distance = (float) Math.sqrt( (x - ball.getX()) * (x - ball.getX()) + (y - ball.getY()) * (y - ball.getY()));
		
		velX = (int) ((-15/distance) * diffX);
		velY = (int) ((-15/distance) * diffY);
		
		count();
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
		//g.setColor(Color.green);
		//g2d.draw(getBounds());
		//g.drawString("Score" + score, 120, 10);
	}
}