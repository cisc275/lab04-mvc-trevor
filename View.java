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
	
	JFrame frame;
	int frameNum =0;
	int picNum = 0;
	BufferedImage[][] pics;
    int xLoc=0;
	int yLoc=0;
	
	final static String[] orcImages = {"images/orc/orc_forward_southeast.png", "images/orc/orc_forward_northwest.png", 
										"images/orc/orc_forward_southwest.png", "images/orc/orc_forward_northeast.png",
										"images/orc/orc_forward_east.png","images/orc/orc_forward_south.png", "images/orc/orc_forward_north.png",
										"images/orc/orc_forward_west.png"};
	int southeast = 0;
	int northwest = 1;
	int southwest = 2;
	int northeast = 3;
	
	
	public View(){
		
		this.setPics();
		frame = new JFrame();
		//frame.getContentPane().add(this);
		frame.setBackground(Color.gray);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(frameWidth, frameHeight);
    	frame.setVisible(true);
	}
	
	
	
	
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
	
	public void update(int x, int y, String dir){ //Problem is somehwere related to this guy I think
		
		this.xLoc = x;
		this.yLoc = y;
		
		if (dir.equals(Direction.SOUTHEAST.getName())){
			picNum = southeast;
		}
		if (dir.equals(Direction.SOUTHWEST.getName())){
			picNum = southwest;
		}
		if (dir.equals(Direction.NORTHEAST.getName())){
			picNum = northeast;
		}
		if (dir.equals(Direction.NORTHWEST.getName())){
			picNum = northwest;
		}
		
		frame.getContentPane().add(this);
		frameNum = (frameNum+1) % frameCount;
		System.out.println(Integer.toString(picNum) + " " + Integer.toString(frameNum));
		frame.repaint();

	}
	
	
	public void paint(Graphics g) {
		frameNum= (frameNum + 1) % frameCount;
		g.drawImage(pics[picNum][frameNum], xLoc, yLoc, Color.gray, this);
    
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
	
	
	private void setPics(){
	pics = new BufferedImage[8][10];
    	for(int i = 0; i < orcImages.length; i++) {
    		BufferedImage img = createImage(orcImages[i]);
    			for(int j = 0; j < frameCount; j++) {
    				pics[i][j] = img.getSubimage(imgWidth*j, 0, imgWidth, imgHeight);
    		}
    	}
	}
	
	
	
	
	
    
}
