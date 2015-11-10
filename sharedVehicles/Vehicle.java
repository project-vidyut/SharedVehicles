package sharedVehicles;

import sim.engine.SimState;
import sim.util.Bag;
import sim.util.Int2D;

public class Vehicle extends Movable  {

    public Vehicle(int xdir, int ydir, int[][] p) {
		super(xdir, ydir, p);
		// TODO Auto-generated constructor stub
	}
    
    
    public void step(SimState state) throws NullPointerException
    {
	int flag = 0;
	int stopX = 20,stopY =40, stopX1 = 80, stopY1=60;
	int stopFlag = 0;
	

    Simulation tut = (Simulation)state;
    
    Int2D location = tut.particles.getObjectLocation(this);

    // move
 
    int x1 = Path[pathIndex][0], y1 = Path[pathIndex][1], x2 = Path[pathIndex+1][0], y2 = Path[pathIndex+1][1];
    
    int dist = distance(Path[pathIndex][0],Path[pathIndex][1],Path[pathIndex+1][0],Path[pathIndex+1][1]);
   
    int curDistance = distance(location.x,location.y,Path[pathIndex][0],Path[pathIndex][1]);
    System.out.println(curDistance);
    if(curDistance >= dist) {
    	pathIndex = pathIndex + 1;
    }
   
    if( location.x == 20 && location.y == 40) {
    	stop(tut);
    	stopFlag = 1;
    }    
    
   try {
   Int2D newloc = new Int2D(20,20);
   Bag p = tut.particles.getObjectsAtLocation(20, 20);
   if(stopFlag==0) {
   if(p.size()>1 || flag == 1) {
	   moveToAndFro(Path,tut);
	   flag = 1;
   }
   }
   }
   catch(NullPointerException e) {
	   moveToAndFro(Path,tut);

   }
   
   
  /* 
   Bag g = tut.particles.getAllObjects();
   Vehicle v = (Vehicle)g.get(1);
   Int2D loc = tut.particles.getObjectLocation(v);
   System.out.println(" Location of Vehicle:"+loc.x);
   System.out.println(" Location of Vehiecle"+loc.y);
*/

 

  }
    
    
    
	
	public double getCharge() {
		return 0;
	}
	
	public void setCharge() {
		
	}
	
	public void startCharging() {
		
	}
	
	public void endCharging() {
		
	}
	
	public void startMeter() {
		
	}
	
	public void stopMeter() {
		
	}
	
	public void getCost() {
		
	}

	
}
