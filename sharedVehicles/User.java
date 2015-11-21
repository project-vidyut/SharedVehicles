package sharedVehicles;

import sim.engine.SimState;
import sim.util.Bag;
import sim.util.Int2D;

public class User extends Movable {

    public User(int xdir, int ydir, int[][] p,int ui) {
		super(xdir, ydir, p,ui);
		// TODO Auto-generated constructor stub
	}
    
    public int followFlag = 0;
    
    public void step(SimState state)
    {
	
	int stopX = 20,stopY =40, stopX1 = 80, stopY1=60;
	
    Simulation sim = (Simulation)state;
    Int2D location = sim.particles.getObjectLocation(this);
    moveAndStop(Path,sim);
    
 
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
