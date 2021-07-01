package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import main.Game.STATE;

public class Menu extends MouseAdapter {

	private Game game;
	private Handler handler;
	private Random r;
	
	private int bx1 = 210;
	private int bw1 = 200;
	
	private int bx2 = 210;
	private int bw2 = 200;
	
	private int bx3 = 210;
	private int bw3 = 200;
	
	private int bx4 = 210;
	private int bw4 = 200;
	
	private int bx5 = 210;
	private int bw5 = 200;
	
	private int bx6 = 210;
	private int bw6 = 200;
	
	private int bx7 = 210;
	private int bw7 = 200;
	
	private int bx8 = 210;
	private int bw8 = 200;
	
	private Ball ball;
	private Color menuButton1 = Color.white;
	private Color menuButton2 = Color.white;
	private Color menuButton3 = Color.white;
	private Color menuButton4 = Color.white;
	private Color menuButton5 = Color.white;
	private Color menuButton6 = Color.white;
	private Color menuButton7 = Color.white;
	private Color menuButton8 = Color.white;
	
	public static String randomStringFromArr() {
		String[] array = {"Made with JAVA!", "REMASTERED", "1972", "Allan Alcorn", "HELP", "Tennis!", "Go Outside (with a mask)!!! >:(", "<3 u notch!", "Also try Minecraft", "Also try Terraria", "Hydrate!!", "Hello There!", "4:00 AM programming this :/", "Does anyone play this?", "Learn JAVA", "500fps+ guaranteed!!", "No LWJGL :(", ":)"};
		
		return null;
			}
	
	public Menu(Game game, Handler handler, Ball ball){
		this.game = game;
		this.handler = handler;
		this.ball = ball;
		this.r = r;
		
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
			
		if(game.gameState == STATE.Menu) {
			//Play Button
			if(mouseOver(mx, my, 200, 150, 200, 64)) {
				game.gameState = STATE.Game;
				handler.addObject(new Player(0, 175, ID.Player, handler));	
				handler.addObject(new Bot(607, 175, ID.Bot, handler));
				handler.addObject(new Ball(310, 220, ID.Ball, handler));
				handler.addObject(new InvisWallR(640, 0, ID.InvisWallR, handler));
				handler.addObject(new InvisWallL(220, 0, ID.InvisWallL, handler));
			}
			//Settings Button
			if(mouseOver(mx, my, 210, 250, 200, 64)) {
				game.gameState = STATE.Settings;
				return;
			}
			//Exit Button
			if(mouseOver(mx, my, 200, 350, 200, 64)) {
				System.exit(1);
				
			}
		}
		//SETTINGS BUTTONS
		if(game.gameState == STATE.Settings) {
			
			if(mouseOver(mx, my, 210, 150, 200, 64)) {
				game.gameState = STATE.Controls;
			}
			if(mouseOver(mx, my, 210, 250, 200, 64)) {
				game.gameState = STATE.Credits;
			}
			if(mouseOver(mx, my, 210, 350, 200, 64)) {
				game.gameState = STATE.Menu;
			}
		}
		if(game.gameState == STATE.Controls) {
			if(mouseOver(mx, my, 210, 350, 200, 64)) {
				game.gameState = STATE.Settings;
			}
		}
		//CREDITS BUTTONS
		if(game.gameState == STATE.Credits) {
			if(mouseOver(mx, my, 210, 350, 200, 64)) {
				game.gameState = STATE.Settings;
			}
			if(mouseOver(mx, my, 210, 250, 200, 64)) {
				game.gameState = STATE.Credits;
			}return;
		}
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
	}
	public void tick() {
		if(menuButton1 == Color.white) {
			bx1 += (230 - bx1) * 0.05; //210
			bw1 += (200 - bw1) * 0.05; //200
		}else {
			bx1 += (120 - bx1) * 0.05; //210
			bw1 += (400 - bw1) * 0.05; //200
		}
		if(menuButton2 == Color.white) {
			bx2 += (230 - bx2) * 0.05; //210
			bw2 += (200 - bw2) * 0.05; //200
		}else {
			bx2 += (120 - bx2) * 0.05; //210
			bw2 += (400 - bw2) * 0.05; //200
		}
		if(menuButton3 == Color.white) {
			bx3 += (230 - bx3) * 0.05; //210
			bw3 += (200 - bw3) * 0.05; //200
		}else {
			bx3 += (120 - bx3) * 0.05; //210
			bw3 += (400 - bw3) * 0.05; //20
		}
		if(menuButton4 == Color.white) {
			bx4 += (230 - bx4) * 0.05; //210
			bw4 += (200 - bw4) * 0.05; //200
		}else {
			bx4 += (120 - bx4) * 0.05; //210 
			bw4 += (400 - bw4) * 0.05; //20
		}
		if(menuButton5 == Color.white) {
			bx5 += (230 - bx5) * 0.05; //210
			bw5 += (200 - bw5) * 0.05; //200
		}else {
			bx5 += (120 - bx5) * 0.05; //210 
			bw5 += (400 - bw5) * 0.05; //20
		}
		if(menuButton6 == Color.white) {
			bx6 += (230 - bx6) * 0.05; //210
			bw6 += (200 - bw6) * 0.05; //200
		}else {
			bx6 += (120 - bx6) * 0.05; //210 
			bw6 += (400 - bw6) * 0.05; //20
		}
		if(menuButton7 == Color.white) {
			bx7 += (230 - bx7) * 0.05; //210
			bw7 += (200 - bw7) * 0.05; //200
		}else {
			bx7 += (120 - bx7) * 0.05; //210 
			bw7 += (400 - bw7) * 0.05; //20
		}
		if(menuButton8 == Color.white) {
			bx8 += (230 - bx8) * 0.05; //210
			bw8 += (200 - bw8) * 0.05; //200
		}else {
			bx8 += (120 - bx8) * 0.05; //210 
			bw8 += (400 - bw8) * 0.05; //20
		}
	}
	public void mouseMoved(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(game.gameState == STATE.Menu) {
			//Play Button
			if(mouseOver(mx, my, 210, 150, 200, 64)) {
				menuButton1 = Color.green;
			}else{ 
				menuButton1 = Color.white;
			}
			//Controls Button
			if(mouseOver(mx, my, 210, 250, 200, 64)) {
				menuButton2 = Color.yellow;
			}else{
				menuButton2 = Color.white;
			}
			//Quit Button
			if(mouseOver(mx, my, 210, 350, 200, 64)) {
				menuButton3 = Color.red;
			}else{
				menuButton3 = Color.white;
			}
		}
			
		if(game.gameState == STATE.Settings) {
				
			if(mouseOver(mx, my, 210, 150, 200, 64)) {
				menuButton4 = Color.green;
			}else{ 
				menuButton4 = Color.white;
			}
			if(mouseOver(mx, my, 210, 250, 200, 64)) {
				menuButton5 = Color.yellow;
			}else{
				menuButton5 = Color.white;
			}
			//Back Button
			if(mouseOver(mx, my, 210, 350, 200, 64)) {
				menuButton6 = Color.red;
			}else{
				menuButton6 = Color.white;
			}
			}
			if(game.gameState == STATE.Controls) {
			if(mouseOver(mx, my, 210, 350, 200, 64)) {
				menuButton7 = Color.red;
			}else {
				menuButton7 = Color.white;
			}
		}
			if(game.gameState == STATE.Credits) {
				if(mouseOver(mx, my, 210, 350, 200, 64)) {
					menuButton8 = Color.red;
				}else {
					menuButton8 = Color.white;
				}
			}
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		if(game.gameState == STATE.Menu) {
			
		//Font for Menu
		Font font = new Font("arial", 1, 50);
		
		Font font2 = new Font("arial", 1, 30);
		
		Font font3 = new Font("arial", 1, 70);
		
		g.setFont(font2);
		g.setColor(Color.yellow);
		//g.drawString(array, 180, 100);
		
		//Menu Title
		g.setFont(font3);
		g.setColor(Color.white);
		g.drawString("P O N G", 180, 100);
		
		g.setFont(font2);
		g.setColor(menuButton1);
		g.drawString("PLAY", 270, 192);
		g.drawRect(bx1, 150, bw1, 64);
		g.setColor(Color.white);
		
		g.setColor(menuButton2);
		g.drawString("SETTINGS", 240, 292);
		g.drawRect(bx2, 250, bw2, 64);
		g.setColor(Color.white);
		
		g.setColor(menuButton3);
		g.drawString("EXIT", 280, 392);
		g.drawRect(bx3, 350, bw3, 64);
		g.setColor(Color.white);
		}else if(game.gameState == STATE.Settings) {
			
			//Font for Controls
			Font font = new Font("arial", 1, 50);
			
			Font font2 = new Font("arial", 1, 30);
			
			g.setFont(font);
			//Controls Title
			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("SETTINGS", 190, 70);
			//Control
			g.setFont(font2);
			g.setColor(menuButton4);
			g.drawString("CONTROLS", 230, 192);
			g.drawRect(bx4, 150, bw4, 64);
			g.setColor(Color.white);
			
			g.setColor(menuButton5);
			g.drawString("CREDITS", 245, 292);
			g.drawRect(bx5, 250, bw5, 64);
			g.setColor(Color.white);
			
			g.setColor(menuButton6);
			g.drawString("BACK", 270, 392);
			g.drawRect(bx6, 350, bw6, 64);
			g.setColor(Color.white);
		}else if(game.gameState == STATE.Controls) {
			
			
			g.drawString("W = to move UP", 50, 130);
			g.drawString("A = to move LEFT", 50, 190);
			g.drawString("S = to move DOWN", 50, 250);
			g.drawString("D = to move RIGHT", 50, 310);
			
			//Fonts
			Font font = new Font("arial", 1, 50);
			Font font2 = new Font("arial", 1, 30);
			
			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("Controls", 50, 70);
			
			g.setFont(font2);
			g.setColor(Color.white);
			g.drawString("W = to move UP", 50, 130);
			g.drawString("A = to move LEFT", 50, 190);
			g.drawString("S = to move DOWN", 50, 250);
			g.drawString("D = to move RIGHT", 50, 310);
			
			g.setFont(font2);
			g.setColor(menuButton7);
			g.drawString("BACK", 270, 392);
			g.drawRect(bx7, 350, bw7, 64);
			g.setColor(Color.white);
			
		}else if(game.gameState == STATE.Credits) {
			
			//Fonts
			Font font = new Font("arial", 1, 50);
			Font font2 = new Font("arial", 1, 30);
			Font font3 = new Font("arial", 1, 20);
			
			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("CREDITS",200, 50);
			
			
			g.setFont(font2);
			g.setColor(Color.white);
			g.drawString("Game Designer", 205, 100);
			g.setFont(font3);
			g.setColor(Color.yellow);
			g.drawString("Robatortas", 260, 130);
			g.setColor(Color.white);
			g.setFont(font2);
			g.drawString("Game Programmer", 180, 170);
			g.setFont(font3);
			g.setColor(Color.yellow);
			g.drawString("Robatortas", 260, 200);
			g.setColor(Color.white);
			g.setFont(font2);
			g.drawString("Original Creator", 200, 240);
			g.setFont(font3);
			g.setColor(Color.yellow);
			g.drawString("Allan Alcorn", 255, 270);
			g.setColor(Color.white);
			g.setFont(font2);
			g.drawString("Thanks to", 240, 310);
			g.setFont(font3);
			g.setColor(Color.yellow);
			g.drawString("Notch", 280, 340);
			g.setColor(Color.white);
			
			g.setFont(font2);
			g.setColor(menuButton8);
			g.drawString("BACK", 270, 392);
			g.drawRect(bx8, 350, bw8, 64);
			g.setColor(Color.white);
			
		}else if(game.gameState == STATE.End) {
			game.gameState = STATE.End;
			//Fonts for END SCREEN
			Font font = new Font("arial =",1 ,50);
			Font font2 = new Font("arial",1 ,30);
			
			//Title for END SCREEN
			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("You Lost", 100, 100);
		}
	}
}
