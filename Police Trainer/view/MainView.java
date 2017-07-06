package view;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import model.*;

public class MainView extends JPanel implements MouseListener{
	private Screen s = new Screen();
	ArrayList<BufferedImage> iPics = new ArrayList<BufferedImage>();
	ArrayList<BufferedImage> cPics = new ArrayList<BufferedImage>();

	public MainView(){

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
	}
	
}