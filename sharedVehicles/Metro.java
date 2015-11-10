package sharedVehicles;

import sim.engine.*;
import sim.field.grid.*;
import sim.util.*;
import ec.util.*;

public class Metro extends Movable {
    public Metro(int xdir, int ydir, int[][] p) {
		super(xdir, ydir, p);
		// TODO Auto-generated constructor stub
	}



	private static final long serialVersionUID = 1;



    public void step(SimState state)
        {
    	
    	int stopX = 20,stopY =40, stopX1 = 80, stopY1=60;
    	
        Simulation tut = (Simulation)state;
        Int2D location = tut.particles.getObjectLocation(this);
        int x1 = Path[pathIndex][0], y1 = Path[pathIndex][1], x2 = Path[pathIndex+1][0], y2 = Path[pathIndex+1][1];
        int dist = distance(Path[pathIndex][0],Path[pathIndex][1],Path[pathIndex+1][0],Path[pathIndex+1][1]);
        int curDistance = distance(location.x,location.y,Path[pathIndex][0],Path[pathIndex][1]);

        if(curDistance >= dist) {
        	pathIndex = pathIndex + 1;
        }
        
        if( location.x == stopX && location.y == stopY) {
        	stopCount = stopCount +1;
        } 
        
       if(stopCount == 0 ||stopCount > 20) {
       moveToAndFro(Path,tut);
       stopCount=0;
       }
     
       }

}
