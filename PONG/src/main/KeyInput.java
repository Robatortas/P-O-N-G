package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	
	public KeyInput(Handler handler) {
		this.handler = handler;
		
		//when key not pressed = false
		//when key pressed = true
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player) {
				//key events for player WASD
				
				if(key == KeyEvent.VK_W) { tempObject.setVelY(-10); keyDown[0] = true; }
				if(key == KeyEvent.VK_S) { tempObject.setVelY(10); keyDown[1] = true; }
				if(key == KeyEvent.VK_D) { tempObject.setVelX(10); keyDown[2] = true; }
				if(key == KeyEvent.VK_A) { tempObject.setVelX(-10); keyDown[3] = true; }
			}
			for(int i1 = 0; i1 < handler.object.size(); i1++) {
				GameObject tempObject1 = handler.object.get(i1);
				
				if(tempObject1.getID() == ID.Player) {
					//key events for player Arrow Keys
					
					if(key == KeyEvent.VK_UP) { tempObject1.setVelY(-10); keyDown[0] = true; }
					if(key == KeyEvent.VK_DOWN) { tempObject1.setVelY(10); keyDown[1] = true; }
					if(key == KeyEvent.VK_RIGHT) { tempObject1.setVelX(10); keyDown[2] = true; }
					if(key == KeyEvent.VK_LEFT) { tempObject1.setVelX(-10); keyDown[3] = true; }
				}
			}
		}
		//Exit the game with esc key
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player) {
				//key events for player WASD
				
				if(key == KeyEvent.VK_W) keyDown[0] = false;
				if(key == KeyEvent.VK_S) keyDown[1] = false;
				if(key == KeyEvent.VK_D) keyDown[2] = false;
				if(key == KeyEvent.VK_A) keyDown[3] = false;
				
				//vertical movement WASD
				if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
				//horizontal movement WASD
				if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
			}
		}
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player) {
				//key events for player Arrow Keys
				
				if(key == KeyEvent.VK_UP) keyDown[0] = false;
				if(key == KeyEvent.VK_DOWN) keyDown[1] = false;
				if(key == KeyEvent.VK_RIGHT) keyDown[2] = false;
				if(key == KeyEvent.VK_LEFT) keyDown[3] = false;
				
				//vertical movement Arrow Keys
				if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
				//horizontal movement Arrow Keys
				if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
			}
	}
  }
}