package main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.Handler;

public class Trail extends GameObject {

	//assignments
	private float alpha = 1;
	private float life;
	
	private Handler handler;
	private Color color;
	
	private int width, height;
	
	//method
	public Trail(int x, int y, ID id, Color color, float life, int width, int height, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		this.width = width;
		this.height = height;
		this.color = color;
		this.life = life;
		
	}


	public void tick() {
		if(alpha > life) {
			//the life float number controls the trail limit
			alpha -= (life - 0.0001f);
		}else handler.removeObject(this);
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		g.setColor(color);
		g.fillOval((int)x, (int)y, width, height);
		g2d.setComposite(makeTransparent(1));
	}


	private Composite makeTransparent(float alpha2) {
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}


	
	public Rectangle getBounds() {
		return null;
	}

}
