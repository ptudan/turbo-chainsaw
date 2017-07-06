
package model;
import java.awt.Rectangle;
import java.awt.Point;
import java.util.Random;

public class Window{
	private int x;
	private int y;
	private int width;
	private int height;
	private int contains;
	private final int EMPTY = 0;
	private final int CRIMINAL = 1;
	private final int DEAD_CRIMINAL = 3;
	private final int INNOCENT = 2;
	private final int DEAD_INNOCENT = 4;
	private int maxTime;
	private int curTime;
	private Rectangle rect;
	private Random r = new Random();

	public Window(int x, int y, int width, int height, int maxTime){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		rect = new Rectangle(x, y, width, height);
		this.maxTime = maxTime;
		contains = 0;
		curTime = 0;

	}

	public void setXY(int x, int y){
		this.x = x;
		this.y = y;
		rect = new Rectangle(x, y, width, height);
	}

	public boolean clashesWith(Rectangle r2){
		return rect.intersects(r2);
	}

	public int tickTimer(){
		curTime++;
		if(curTime>=maxTime){
			curTime = 0;
			if(contains == CRIMINAL){
				contains = r.nextInt(3);
				return 1;
			}
			contains = r.nextInt(3);
		}
		return 0;
	}

	private void getShot(){
		if(contains==CRIMINAL) contains = DEAD_CRIMINAL;
		else if(contains==INNOCENT) contains = DEAD_INNOCENT;
		return;
	}

	public int getContains(){
		return contains;
	}

	public void checkShot(Point p){
		if(rect.contains(p)){
			getShot();
		}
	}




}