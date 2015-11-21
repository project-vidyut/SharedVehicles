package sharedVehicles;

import sim.engine.*;
import sim.util.*;


public class Movable implements Steppable
{
private static final long serialVersionUID = 1;

public int xdir;  // -1, 0, or 1
public int ydir;  // -1, 0, or 1
public int pathIndex = 0;
int[][] Path;
public int stopCount = 0;
public int stopCount1 = 0;
public int UID;
public boolean stopFlag = false;



public Movable(int xdir, int ydir, int[][] p,int ui)
    {
    this.xdir = xdir;
    this.ydir = ydir;
    Path = p;
    UID = ui;
    }

public Movable(int xdir, int ydir, int ui)
{
this.xdir = xdir;
this.ydir = ydir;
UID = ui;
}


public void step(SimState state)
    { 

  }

public void moveObject(Simulation tutorial,int x1,int y1,int x2, int y2) {
	System.out.println("Moving :-->"+x1+" "+y1+" "+" "+x2+" "+y2);
    Int2D location = tutorial.particles.getObjectLocation(this);
    int newx=location.x,newy=location.y;
    
    if(location.x == x2) {
  //  	System.out.println("Entering x=x2");
    	if(y2 > y1) {
        	xdir=0;
        	ydir=1;
    	}
    	if(y2 < y1) {
        	xdir=0;
        	ydir=-1;
    	}
 //   	System.out.println("xdir:"+xdir+" "+"ydir"+ydir);
    }
    if(location.y == y2) {
  //  	System.out.println("Entering y=y2");	
    	if(x2 > x1) {
        	xdir=1;
        	ydir=0;
    	}
    	if(x2 < x1) {
        	xdir=-1;
        	ydir=0;
    	}
  //  	System.out.println("xdir:"+xdir+" "+"ydir"+ydir);	
    }
 
            
    newy = location.y + ydir;
    newx = location.x + xdir;
    Int2D newloc = new Int2D(newx,newy);

    tutorial.particles.setObjectLocation(this,newloc);    
	
}

public void moveToAndFro(int[][] p, Simulation tut) {
	
	    int length = p.length-1;
	 
	    Int2D location = tut.particles.getObjectLocation(this);
	    
		 if(pathIndex==length) {
			 Path = reversePath(Path);
			 pathIndex=0;
		 }

	 
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
	    System.out.println("Path index before the move object in movable:"+pathIndex);
	    moveObject(tut,Path[pathIndex][0],Path[pathIndex][1],Path[pathIndex+1][0],Path[pathIndex+1][1]);
	    
}

public void moveToAndFrom(int[][] p, Simulation tut) {
	
    int length = p.length-1;
 
    Int2D location = tut.particles.getObjectLocation(this);
    
	 if(pathIndex==length) {
		 Path = reversePath(Path);
		 pathIndex=0;
	 }

 
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
    if(pathIndex<=length) {	
    System.out.println("Path index before moveObject:"+pathIndex+" Path length "+Path.length +"");
    moveObject(tut,Path[pathIndex][0],Path[pathIndex][1],Path[pathIndex+1][0],Path[pathIndex+1][1]);
    }
}

public void moveAndStop(int[][] p, Simulation sim) {
	 int length = p.length-2;
	 
	    Int2D location = sim.particles.getObjectLocation(this);
	    

	
		 if(pathIndex>length) {
			System.out.println("Stopping the agent :"+this.UID+" at location "+location.x+","+location.y); 
			this.stop(sim);
		 } else {
			    int x1 = Path[pathIndex][0], y1 = Path[pathIndex][1], x2 = Path[pathIndex+1][0], y2 = Path[pathIndex+1][1];
			    		        
			    // set my new location
			    int dist = distance(Path[pathIndex][0],Path[pathIndex][1],Path[pathIndex+1][0],Path[pathIndex+1][1]);			   
			    int curDistance = distance(location.x,location.y,Path[pathIndex][0],Path[pathIndex][1]);	 

	    if(curDistance >= dist) {
	    	pathIndex = pathIndex + 1;
	    }
	    if(pathIndex<=length) {	      		
	    		moveObject(sim,Path[pathIndex][0],Path[pathIndex][1],Path[pathIndex+1][0],Path[pathIndex+1][1]);

	    }
		}
	   
	
	
}



public int distance(int x1,int y1, int x2, int y2) {
	return Math.abs(x1-x2) + Math.abs(y2-y1);
}

public void stop(Simulation tut) {
    Int2D location = tut.particles.getObjectLocation(this);
    int newy = location.y;
    int newx = location.x;
    Int2D newloc = new Int2D(newx,newy);
    tut.particles.setObjectLocation(this,newloc);   	
}

public int[][] reversePath(int[][] p) {

	
	for(int i = 0; i < p.length / 2; i++)
	{
	    int[] temp = p[i];
	    p[i] = p[p.length - i - 1];
	    p[p.length - i - 1] = temp;
	}
	
	return p;
	
}


}
