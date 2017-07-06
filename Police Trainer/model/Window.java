

public class Window{
	private int x;
	private int y;
	private int width;
	private int height;
	private int contains;//0 is an empty window, 1 is a criminal, 2 is an innocent
	private int maxTime;
	private int curTime;

	public Window(int x, int y, int width, int height, int maxTime){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.maxTime = maxTime;
		contains = 0;
		curTime = 0;

	}

	public void setXY(int x, int y){
		this.x = x;
		this.y = y;
	}





}