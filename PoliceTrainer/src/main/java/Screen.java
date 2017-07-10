//package model;
import java.util.*;
import java.awt.Rectangle;
import java.awt.Point;

public class Screen{
	
	private final static int boardHeight = 800;
	private final static int boardWidth = 1280;
	private int minTime = 500;
	private List<Window> windows = new ArrayList<Window>();
	private List<BulletHole> bullets = new ArrayList<BulletHole>();
	private int score = 0;
	private Random r = new Random();
	private int lives = 3;

	public Screen(){
		spawnWindows(5);
	}

	public int getScore(){
		return score;
	}

	public int getLives(){
		return lives;
	}

	public List<Window> getWindows(){
		return windows;
	}

	public static int getBoardHeight(){
		return boardHeight;
	}

	public static int getBoardWidth(){
		return boardWidth;
	}

	public void spawnWindows(int count){
		if(count < 0 || count > 8) return;

		while(windows.size()<count){
			boolean repeat = true;
			int x = -1, y = -1;
			while(repeat){
				repeat = false;
				x = r.nextInt(boardWidth-ImageData.WINDOW.getActualWidth());
				y = 50+r.nextInt((boardHeight-ImageData.WINDOW.getActualHeight())-50);
				Rectangle r = new Rectangle(x, y, ImageData.WINDOW.getActualWidth(), ImageData.WINDOW.getActualHeight());
				for(Window w : windows){
					if(w.clashesWith(r)){
						repeat = true;
						continue;
					}
				}
			}
			windows.add(new Window(x, y, 50));
		}
	}

	public void spawnBullet(int x, int y){
		bullets.add(new BulletHole(x, y));
	}

	public void tickWindows(){
		ArrayList<Integer> del = new ArrayList<Integer>();
		int ind = 0;
		for(Window w : windows){
			int temp = w.tickTimer();
			if(temp!=0)del.add(ind);

			if(temp == 1){
				getShot();
			}
			else if(temp == 2){
				score++;
			}
			else if(temp == 3){
				score -= 5;
				killInnocent();
			}
			ind++;
		}
		Collections.sort(del, Collections.reverseOrder());
		for(int n : del){
			windows.remove(n);
		}
		spawnWindows(windows.size()+del.size());
	}

	public void tickBullets(){
		ArrayList<Integer> del = new ArrayList<Integer>();
		int ind = 0;
		for(BulletHole b : bullets){
			if(b.disappear()){
				del.add(ind);
			}
			ind++;
		}
		Collections.sort(del, Collections.reverseOrder());
		for(int n : del){
			bullets.remove(n);
		}

	}

	public void checkClick(Point p){
		spawnBullet((int)p.getX(), (int)p.getY());
		for(Window w : windows){
			w.checkShot(p);
		}
	}

	public List<BulletHole> getBullets(){
		return bullets;
	}

	public void delBullets(Window w){
		Rectangle r = w.getRect();
		List<Integer> del = new ArrayList<Integer>();
		int ind = 0;
		for(BulletHole b : bullets){
			int x = b.getX();
			int y = b.getY();
			if(r.contains(x, y)){
				del.add(ind);
			}
			ind++;
		}
		Collections.sort(del, Collections.reverseOrder());
		for(int n : del){
			bullets.remove(n);
		}
	}

	private void killInnocent(){
		lives --;
		if(lives<=0){
			//TO DO: DIE
		}
	}

	private void getShot(){
		lives--;
		if(lives<=0){
			//TO DO: DIE
		}
	}

}