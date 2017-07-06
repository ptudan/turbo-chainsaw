package model;
import java.util.*;
import java.awt.Rectangle;

public class Screen{
	
	private final static int boardHeight = 600;
	private final static int boardWidth = 800;
	private int minWindowWidth = 50;
	private int maxWindowWidth = 150;
	private int minTime = 500;
	private List<Window> windows = new ArrayList<Window>();
	private int score = 0;
	private Random r = new Random();
	private int lives = 3;

	public Screen(){

	}

	private void spawnWindows(int count){
		if(count < 0 || count > 8) return;

		while(windows.size()<count){
			boolean repeat = true;
			int width = -1, height = -1, x = -1, y = -1;
			while(repeat){
				repeat = false;
				width = minWindowWidth + r.nextInt(maxWindowWidth - minWindowWidth);
				height = (5*width)/3;
				x = r.nextInt(boardWidth-width);
				y = r.nextInt(boardHeight-height);
				Rectangle r = new Rectangle(x, y, width, height);
				for(Window w : windows){
					if(w.clashesWith(r)){
						repeat = true;
						continue;
					}
				}
			}
			windows.add(new Window(x, y, width, height, 15));
		}
	}

	private void tickWindows(){
		for(Window w : windows){
			if(w.tickTimer() == 1){
				getShot();
			}
		}
	}

	private void getShot(){
		lives--;
		if(lives<=0){
			//TO DO: DIE
		}
	}

}