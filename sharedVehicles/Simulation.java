package sharedVehicles;
import sim.engine.*;
import sim.field.grid.*;
import sim.util.*;


public class Simulation extends SimState
    {
    private static final long serialVersionUID = 1;

    public DoubleGrid2D trails;
    public SparseGrid2D particles;
    
    public int gridWidth = 100;
    public int gridHeight = 100;
    public int numParticles = 1;
    
    public Simulation(long seed)
        {
        super(seed);
        }

    public void start()
        {
        super.start();
        trails = new DoubleGrid2D(gridWidth, gridHeight);
        particles = new SparseGrid2D(gridWidth, gridHeight);
        

        
    	 Metro m = new Metro(0,0,Path.getPath(0),0);  // random directions
         schedule.scheduleRepeating(m);
         particles.setObjectLocation(m,new Int2D(0,75));  // random location	


         Vehicle v = new Vehicle(0,0,8);
         schedule.scheduleRepeating(v);
         particles.setObjectLocation(v,new Int2D(10,85));  
        
        User u1;
           
        
        for(int k=0;k<6;k++) {
        	 
        	 int[][] pt = Path.getPath(k+1);
        	 u1 = new User(0,0,pt,k+1);  // random directions
             schedule.scheduleRepeating(u1);
             particles.setObjectLocation(u1,new Int2D(pt[0][0],pt[0][1]));  // random location	
        	
        } 
       
        }
        

    }
