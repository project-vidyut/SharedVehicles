package sharedVehicles;

import sim.engine.SimState;
import sim.util.Bag;
import sim.util.Int2D;

public class User extends Movable {

    public User(int xdir, int ydir, int[][] p) {
		super(xdir, ydir, p);
		// TODO Auto-generated constructor stub
	}
    
    public int followFlag = 0;
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
    
    if( location.x == 20 && location.y == 40) {
   // 	stop(tut);
    	followFlag = 1;
    	System.out.println("***At Metro Station**** ");

    }  
    
    
    if(followFlag != 0) {
    	System.out.println("***Following Metro**** ");
    	  Bag g = tut.particles.getAllObjects();
    	  Metro m = (Metro)g.get(0);
    	follow(m,tut);
    }
    
    if(followFlag == 0) {
    if(stopCount == 0 ||stopCount > 20) {
    	moveToAndFro(Path,tut);
    	stopCount=0;
    	System.out.println("***Not At Metro**** ");

    }
    }
 
    }
    
    public void follow(Movable m,Simulation sim) {
        Int2D locationM = sim.particles.getObjectLocation(m);
        int newx,newy;
        newx = locationM.x; 
        newy = locationM.y;
        Int2D newloc = new Int2D(newx,newy);
        sim.particles.setObjectLocation(this, newloc);
    }
    
    
	
	public void pickUpVehicle() {
		
	}
	
	public void dropVehicle() {
		
	}
	
	public void getIntoMetro() {
		
	}
	
	public void getDownFromMetro() {
		
	}
	
	public int payMoney() {
		return 0;
	}

}
