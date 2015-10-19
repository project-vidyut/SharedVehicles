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
        
        Movable p;
      
        for(int i=0 ; i<numParticles ; i++)
            {
            p = new Movable(0,0);  // random directions
            schedule.scheduleRepeating(p);
            particles.setObjectLocation(p,
                new Int2D(20,0));  // random location
            }
        }
        

    }
