//package view;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.Point;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.awt.Cursor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;


import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
//import org.imgscalr;


public class MainView extends JPanel implements MouseListener, /*MouseMotionListener,*/ ActionListener{
	private Screen scr;
	//ArrayList<BufferedImage> iPics = new ArrayList<BufferedImage>();
	//ArrayList<BufferedImage> cPics = new ArrayList<BufferedImage>();
	private final int EMPTY = 0;
	private final int CRIMINAL = 1;
	private final int DEAD_CRIMINAL = 3;
	private final int INNOCENT = 2;
	private final int DEAD_INNOCENT = 4;
	BufferedImage crim1;
	BufferedImage crim2;
	BufferedImage inno1;
	BufferedImage inno2;
	BufferedImage empty;

	public MainView(){
		crim1 = createImage("../images/criminal1.png");
		crim2 = createImage("../images/criminal2.png");
		inno1 = createImage("../images/innocent1.png");
		inno2 = createImage("../images/innocent2.png");
		empty = createImage("../images/emptyWindow.png");
		addMouseListener(this);
		this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		scr = new Screen();

	}

	public static void main(String ninas[]){
		JFrame frame = new JFrame();
		MainView m = new MainView();
		frame.getContentPane().add(m);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(Screen.getBoardWidth(), Screen.getBoardHeight());
		frame.setVisible(true);
		Timer t = new Timer(100, m);
		t.start();

	}


	private BufferedImage createImage(String location) {
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(new File(location));
			return bufferedImage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(Window w : scr.getWindows()){//paint windows
			int code = w.getContains();
			BufferedImage temp;
			switch(code){
				case EMPTY: temp = empty;
					break;
				case CRIMINAL: temp = crim1;
					break;
				case DEAD_CRIMINAL: temp = crim2;
					break;
				case INNOCENT: temp = inno1;
					break;
				case DEAD_INNOCENT: temp = inno2;
					break;
				default: temp = empty;
					break;
			}
			//BufferedImage temp2 = 
			g.drawImage(temp, w.getXLoc(), w.getYLoc(), null);
		}
		g.drawString("Score: " + scr.getScore(), 10, 10);
		g.drawString("Lives: " +scr.getLives(), 150, 10);
	}

/*	private BufferedImage getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
	    Graphics2D g2 = resizedImg.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();
	    return resizedImg;
	}
*/

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point p = e.getPoint();
		scr.checkClick(p);

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		scr.tickWindows();
	}
/*
	@Override
	public void mouseDragged(MouseEvent m){

	}

	@Override
	public void mouseMoved(MouseEvent m){

	}*/
	
}