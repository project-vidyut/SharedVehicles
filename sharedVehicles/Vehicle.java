package sharedVehicles;

import sim.engine.SimState;
import sim.util.Bag;
import sim.util.Int2D;

public class Vehicle extends Movable  {
	

    public Vehicle(int xdir, int ydir, int[][] p,int ui) {
		super(xdir, ydir, p,ui);
		// TODO Auto-generated constructor stub
	}
    
    public Vehicle(int xdir, int ydir, int ui) {
		super(xdir, ydir,ui);
		// TODO Auto-generated constructor stub
	}
    
	public boolean moveFlag = false;

    
    
    public void step(SimState state) throws NullPointerException
    { 
    	Simulation sim = (Simulation)state;
    	Int2D location = sim.particles.getObjectLocation(this);
        Bag b = sim.particles.getObjectsAtLocation(location);
        System.out.println("Number of objects:"+b.numObjs);
        System.out.println("entering vehicle..");
        if(checkPassenger(b)) {
        	int[][] p = getVehiclePath(b); 
        	setPath(p);
        	moveFlag = true;
        }
        
        if(moveFlag==true) {
        	moveAndStop(Path,sim);
        }


	
 }
    
    
    
	public void setPath(int[][] pt) {
		Path = pt;
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
	
	private boolean checkPassenger(Bag b) {
		boolean result = false;
		if(b.numObjs>=2) {
			System.out.println("***************Passneger!!!***********");
			result = true;
		}
		return result;
	}
	
	private int[][] getVehiclePath(Bag b) {
		int[][] p = new int[4][2];
        p[0][0] = 10;
        p[0][1] = 85;

        p[1][0] = 25;
        p[1][1] = 85;

        p[2][0] = 75;
        p[2][1] = 85;
        
        p[3][0] = 75;
        p[3][1] = 10;
        
        return p;	
	}

	
}
