package sharedVehicles;

import sim.engine.*;
import sim.util.*;


public class Movable implements Steppable
{
private static final long serialVersionUID = 1;

public int xdir;  // -1, 0, or 1
public int ydir;  // -1, 0, or 1
public int pathIndex = 0;
int[][] Path = new int[8][2];



public Movable(int xdir, int ydir)
    {
    this.xdir = xdir;
    this.ydir = ydir;
    }

public void step(SimState state)
    {
    Simulation tut = (Simulation)state;
    

    Int2D location = tut.particles.getObjectLocation(this);
    Path[0][0] = 20;
    Path[0][1] = 0;

    Path[1][0] = 20;
    Path[1][1] = 50;

    Path[2][0] = 50;
    Path[2][1] = 50;

    Path[3][0] = 50;
    Path[3][1] = 20;

    Path[4][0] = 80;
    Path[4][1] = 20;

    Path[5][0] = 80;
    Path[5][1] = 80;

    Path[6][0] = 50;
    Path[6][1] = 80;

    Path[7][0] = 50;
    Path[7][1] = 100;


    // move
 
    int x1 = Path[pathIndex][0], y1 = Path[pathIndex][1], x2 = Path[pathIndex+1][0], y2 = Path[pathIndex+1][1];
    
            
    // set my new location
   System.out.println(location.x+" "+location.y);
    int dist = distance(Path[pathIndex][0],Path[pathIndex][1],Path[pathIndex+1][0],Path[pathIndex+1][1]);
   
    int curDistance = distance(location.x,location.y,Path[pathIndex][0],Path[pathIndex][1]);
    System.out.println(curDistance);
    if(curDistance >= dist) {
    	pathIndex = pathIndex + 1;
    	System.out.println("Path index"+pathIndex);
 //   	moveObject(tut,Path[pathIndex][0],Path[pathIndex][1],Path[pathIndex+1][0],Path[pathIndex+1][1]);
    }
    moveObject(tut,Path[pathIndex][0],Path[pathIndex][1],Path[pathIndex+1][0],Path[pathIndex+1][1]);
    
  //  moveObject(tut,20,50,50,50);

    }

public void moveObject(Simulation tutorial,int x1,int y1,int x2, int y2) {
	System.out.println("Moving :-->"+x1+" "+y1+" "+" "+x2+" "+y2);
    Int2D location = tutorial.particles.getObjectLocation(this);
    int newx=location.x,newy=location.y;
    
    if(location.x == x2) {
    	System.out.println("Entering x=x2");
    	if(y2 > y1) {
        	xdir=0;
        	ydir=1;
    	}
    	if(y2 < y1) {
        	xdir=0;
        	ydir=-1;
    	}
    	System.out.println("xdir:"+xdir+" "+"ydir"+ydir);
    }
    if(location.y == y2) {
    	System.out.println("Entering y=y2");	
    	if(x2 > x1) {
        	xdir=1;
        	ydir=0;
    	}
    	if(x2 < x1) {
        	xdir=-1;
        	ydir=0;
    	}
    	System.out.println("xdir:"+xdir+" "+"ydir"+ydir);	
    }
 
            
    newy = location.y + ydir;
    newx = location.x + xdir;
    Int2D newloc = new Int2D(newx,newy);

    tutorial.particles.setObjectLocation(this,newloc);    

	
	
}

public int distance(int x1,int y1, int x2, int y2) {
	return Math.abs(x1-x2) + Math.abs(y2-y1);
	
}

public void stop() {
	
}



}
