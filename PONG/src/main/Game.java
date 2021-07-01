package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12*9; //HEIGTH = 480
	
	private static JFrame frame = new JFrame();
	
	private Thread thread;
	
	private boolean running = false ;
	
	private Random r;
	
	private HUD hud;

	private Handler handler;
	
	private Menu menu;
	
	private static String name = "PONG v2";
	
	
	public enum STATE {
		Menu,
		End,
		Settings,
		Credits,
		Controls,
		Game
	};
	
	public STATE gameState = STATE.Menu;
	
	public Game() {
		
		handler = new Handler();
		menu = new Menu(this, handler, null);
		
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		this.addMouseMotionListener(menu);
		
		hud = new HUD();
		//Just in case I need to random something...
		r = new Random();
		
		if(gameState == STATE.Game) {
			handler.addObject(new Player(0, 175, ID.Player, handler));
			handler.addObject(new Bot(607, 175, ID.Bot, handler));
			handler.addObject(new Ball(310, 220, ID.Ball, handler));
			handler.addObject(new InvisWallR(640, 0, ID.InvisWallR, handler));
			handler.addObject(new InvisWallL(220, 0, ID.InvisWallL, handler));
			}
	}
		
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
		}catch(Exception e){
			e.printStackTrace();
		}
		}
	
	public void run() {
		long lastTime = System.nanoTime();
		double ns =1000000000 / 60.0;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int ticks = 0;
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				ticks++;
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(ticks + " tps" + " | " + frames + " fps");
				frame.setTitle(name + " | " + ticks + " tps" + "  " + frames + " fps");
				frames = 0;
				ticks = 0;
				
				//meanings
				//ns = nanoseconds
				//amountOfTicks = ticks per second
				
			}
		}
		stop();
	}
	private void tick() {
		handler.tick();
		
		if(gameState == STATE.Game || gameState == STATE.End ) {
			hud.tick();
		}else if(gameState == STATE.Menu || gameState == STATE.Settings || gameState == STATE.Controls || gameState == STATE.Credits) {
			menu.tick();
		}
	}
	
	private void render() {
		this.requestFocus();
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		if(gameState == STATE.Game || gameState == STATE.End ) {
			hud.render(g);
		}else if(gameState == STATE.Menu || gameState == STATE.Settings || gameState == STATE.Controls || gameState == STATE.Credits) {
			menu.render(g);
		}
		g.dispose();
		bs.show();
	}
	public static int clamp(float var, float min, float max) {
		if(var >= max)
			return (int) (var = max);
		else if(var <= min)
			return (int) (var = min);
		else
			return (int) var;
	}
	
	public static int sign(double d) {
		return 0;
	}
	
	public static void Window() {
		
		Game game = new Game();
		
		System.out.println("RUNNING PONGv2");
		
		System.out.println("");
		
		//Window size config
		Dimension size = new Dimension(WIDTH, HEIGHT);
		frame.setPreferredSize(size);
		frame.setMinimumSize(size);
		
		frame.setTitle(name);
		frame.setResizable(false);
		frame.add(game);
		frame.pack();
		game.start();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		}
	
	public static void main(String[] args) {
		Game game = new Game();
		
		Window();
		
	}
}