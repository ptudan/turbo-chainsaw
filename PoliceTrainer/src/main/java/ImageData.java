
import java.awt.Rectangle;

public enum ImageData {
	WINDOW(150, 240, 150, 240, 1);

	private int actualWidth;
	private int actualHeight;
	private int boundWidth;
	private int boundHeight;
	private int boundXLoc;
	private int boundYLoc;
	private int imageFrames;
	
	private ImageData(int actualWidth, int actualHeight, int boundWidth, int boundHeight, int imageFrames){
		this.actualWidth = actualWidth;
		this.actualHeight = actualHeight;
		this.boundWidth = boundWidth;
		this.boundHeight = boundHeight;
		this.imageFrames = imageFrames;
		boundXLoc = (actualWidth/2)-(boundWidth/2);
		boundYLoc = (actualHeight/2)-(boundHeight/2);
	}
	
	public Rectangle getBound(int x, int y){
		return new Rectangle(boundXLoc+x, boundYLoc+y, boundWidth, boundHeight);
	}

	public int getActualHeight() {
		return actualHeight;
	}
	
	public int getActualWidth() {
		return actualWidth;
	}
	
	public int getBoundHeight() {
		return boundHeight;
	}
	
	public int getBoundWidth() {
		return boundWidth;
	}
	
	public int getImageFrames(){
		return imageFrames;
	}
}
