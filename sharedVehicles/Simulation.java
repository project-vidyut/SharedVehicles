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
        
        int[][] Path = new int[8][2];
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
        
        
        
        int[][] pa = new int[4][2];
        pa[0][0] = 0;
        pa[0][1] = 40;

        pa[1][0] = 50;
        pa[1][1] = 40;

        pa[2][0] = 50;
        pa[2][1] = 60;

        pa[3][0] = 100;
        pa[3][1] = 60;


        
        
        
        Metro m = new Metro(0,0,pa);
        schedule.scheduleRepeating(m);
        particles.setObjectLocation(m,new Int2D(0,40));
        
        Movable p;
    
        for(int i=0 ; i<numParticles ; i++)
            {
            p = new Movable(0,0,Path);  // random directions
            schedule.scheduleRepeating(p);
            particles.setObjectLocation(p,
                new Int2D(20,0));  // random location
            }
        }
        

    }
