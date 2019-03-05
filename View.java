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
	
	
    
    
}
