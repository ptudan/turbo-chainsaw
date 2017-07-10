

public class BulletHole{
	private int x;
	private int y;
	private int time;
	private final int maxTime;

	public BulletHole(int x, int y){
		this.x = x;
		this.y = y;
		time = 0;
		maxTime = 15;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public boolean disappear(){
		time++;
		if(time>=maxTime){
			return true;
		}
		return false;
	}
}