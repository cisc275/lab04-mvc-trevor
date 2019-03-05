/**
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 **/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JPanel {
	
    
    final static int frameWidth = 500;
    final static int frameHeight = 300;
    final static int imgWidth = 165;
    final static int imgHeight = 165;
	final int frameCount = 10;
	
	int frame = 0;
	int picNum = 0;
    
	final static String[] orcImages = {"images/orc/orc_forward_southeast.png", "images/orc/orc_forward_northwest.png", 
										"images/orc/orc_forward_southwest.png", "images/orc/orc_forward_northeast.png",
										"images/orc/orc_forward_east.png","images/orc/orc_forward_south.png", "images/orc/orc_forward_north.png",
										"images/orc/orc_forward_west.png"};
	
	
	public int getWidth(){
		return this.frameWidth;
	}
	
	public int getHeight(){
		return this.frameHeight;
	}
	
	public int getImageWidth(){
		return this.imgWidth;
	}
	
	public int getImageHeight(){
		return this.imgHeight;
	}
	
	
    
	private BufferedImage createImage(String aFile){
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File(aFile));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
	}
	
	
    
}
