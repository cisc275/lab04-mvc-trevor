/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/


public class Model {
	
	Direction d;
	int xloc = 0;
    int yloc = 0;
    final int xIncr = 8;
    final int yIncr = 2;
    int xIncrChange = xIncr;
    int yIncrChange = yIncr;
    
    
    public int getX() {
    	return this.xloc;
    }
    
    public int getY() {
    	return this.yloc;
    }
    
    public String getDirect() {
    	return this.d.getName();
    }
    
    public void changeDirection() { //This is the collision detection. Changes direction based on if statements.
    	
    	if(xloc < 0 || xloc >= View.frameWidth-View.imgWidth) {
    		xIncrChange *= -1;
    	}
    	if(yloc < 0 || yloc >= View.frameHeight-View.imgHeight) {
    		yIncrChange *= -1;
    	}
    	
    	//x+ y+
    	if(xIncrChange > 0 && yIncrChange > 0) {
    		d = Direction.SOUTHEAST;
    	}
    	//x+ y-
    	if(xIncrChange > 0 && yIncrChange < 0) {
    		d = Direction.NORTHEAST;
    	}
    	//x- y+
    	if(xIncrChange < 0 && yIncrChange > 0) {
    		d = Direction.SOUTHWEST;
    	}
    	//x- y-
    	if(xIncrChange < 0 && yIncrChange < 0) {
    		d = Direction.NORTHWEST;
    	}
    
    }
    
    
    
    public void updateLoc() {
    	this.xloc = xloc + xIncrChange;
    	this.yloc = yloc + yIncrChange;
    }
    
    
    public void updateLocationAndDirection() {
    	this.changeDirection();
    	this.updateLoc();
    }
}