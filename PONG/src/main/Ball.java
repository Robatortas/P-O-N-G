package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import main.GameObject;
import main.ID;
import main.Game.STATE;

public class Ball extends GameObject{

	private Handler handler;
	private Random r;
	int scoreR = 0;
	int scoreL = 0;
	Font font = new Font("Agency FB", Font.BOLD,100);
	private Game game;
	
	public Ball(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		velX = 2;
		velY = 3;
	}
	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT -55) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH -40) velX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Ball, Color.white, 0.03f, 16, 16, handler));
		
		collision();
		botCollision();
		wallRCollision();
		wallLCollision();
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 20, 20);
	}
//////////////////////////////////////////////////////////////////COLLISIONS STARTED////////////////////////////////////////////////////////////////////////////
	
	//Collision Player
		private void collision() {
			for(int i = 0; i < handler.object.size(); i++) {
				
				GameObject tempObject = handler.object.get(i);
				
				if(tempObject.getID() == ID.Player){
					if(getBounds().intersects(tempObject.getBounds())) {
							velX *= -1;
							velY *= 1;
							//Increase Speed After Collision of Player
							if(velX <= 11) {
								velX ++;
								velY ++;
							}else velX --;
			}
		}
	}
			
}
	//Collision Bot
		private void botCollision() {
			for(int i = 0; i < handler.object.size(); i++) {
						
				GameObject tempObject = handler.object.get(i);
						
				if(tempObject.getID() == ID.Bot){
					if(getBounds().intersects(tempObject.getBounds())) {	
							velX *= -1;
							velY *= 1;
							//Increase Speed After Collision of Bot
							if(velX <= 11) {
								velX--;
								velY--;
							}else velX++; velY++;
					}
				}
			}
		}
				//Points for Player
				public void pointsL() {
					scoreL++;
				}
				//Collision InvisWallR
				private void wallRCollision() {
					for(int i = 0; i < handler.object.size(); i++) {
						
						GameObject tempObject = handler.object.get(i);
						
						if(tempObject.getID() == ID.InvisWallR){
							if(getBounds().intersects(tempObject.getBounds())) {
								//Reset Ball Position
								x = 310;
								y = 220;
								velX = -2;
								velY = 4;
								//Points
								pointsL();
								
					}
				}
			}
		}
				//Points for Bot
				public void pointsR() {
					scoreR++;
				}
				//Collision InvisWallL
				private void wallLCollision() {
					for(int i = 0; i < handler.object.size(); i++) {
						
						GameObject tempObject = handler.object.get(i);
						
						if(tempObject.getID() == ID.InvisWallL){
							if(getBounds().intersects(tempObject.getBounds())) {
								//Reset Ball Position
								x = 310;
								y = 220;
								velX = 3;
								velY = 4;
								//Points
								pointsR();
								
					}
				}
			}
		}
				
/////////////////////////////////////////////COLLISIONS ENDED//////////////////////////////////////////////

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.white);
		g.fillOval(x, y, 16, 16);
		g.setFont(font);
		g.drawString("" + scoreR, 335, 90);
		g.drawString("" + scoreL, 235, 90);
		//g.setColor(Color.MAGENTA);
		//g2d.draw(getBounds());
		
		//Restarts score after 10 points
		if((int) scoreL >= 10) {
			scoreL = 0;
			scoreR = 0;
		}
		if((int) scoreR >= 10) {
			scoreR = 0;
			scoreL = 0;
		}
	}
	//IM GOING TO DIE
	public void mom() {
		if(scoreL == 10) {
			game.gameState = STATE.End;
		}
	}
	
	public int setScoreL(int scoreL) {
		return this.scoreL = scoreL;
		
	}
	public int getScoreL(){
		return scoreL;
	}
	public int setScoreR(int scoreR) {
		return this.scoreR = scoreR;
		
	}
	public int getScoreR(){
		return scoreR;
	}
}
