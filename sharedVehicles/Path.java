package sharedVehicles;
import java.util.Random;

public class Path {
	public int[][] points;

	
	
	public Path(int n,int[][] p) {
	points = p;
	}
	
	
	public static int[][] generateRandomPath(int n) {
	int[][] points = new int[n][2];
	int[] p = {0,20,40,60,80,100};
	Random r = new Random();
	
	for(int i=0;i<n;i++) {
		points[i][0] = p[r.nextInt(6)];
		points[i][1] = p[r.nextInt(6)];
	}
	

	return 	points;
	}
	
	public static int[][] getPath(int n) {
		int[][] points;
		switch(n) {
		
		case 0 :
			points = new int[5][2];
	        points[0][0] = 0;
	        points[0][1] = 75;

	        points[1][0] = 25;
	        points[1][1] = 75;

	        points[2][0] = 25;
	        points[2][1] = 25;
	        
	        points[3][0] = 75;
	        points[3][1] = 25;
	        
	        points[4][0] = 100;
	        points[4][1] = 25;	
		break;
		
		
		case 1 :
			points = new int[5][2];
	        points[0][0] = 0;
	        points[0][1] = 85;

	        points[1][0] = 25;
	        points[1][1] = 85;

	        points[2][0] = 75;
	        points[2][1] = 85;

	        points[3][0] = 75;
	        points[3][1] = 25;
	        
	        points[4][0] = 75;
	        points[4][1] = 0;	
		break;
		
		case 2 :
			points = new int[5][2];
	        points[0][0] = 25;
	        points[0][1] = 100;

	        points[1][0] = 25;
	        points[1][1] = 75;

	        points[2][0] = 25;
	        points[2][1] = 25;

	        points[3][0] = 75;
	        points[3][1] = 25;
	        
	        points[4][0] = 100;
	        points[4][1] = 25;
		break;
		
		case 3 :
			points = new int[5][2];
	        points[0][0] = 25;
	        points[0][1] = 100;

	        points[1][0] = 25;
	        points[1][1] = 75;

	        points[2][0] = 25;
	        points[2][1] = 25;

	        points[3][0] = 75;
	        points[3][1] = 25;
	        
	        points[4][0] = 75;
	        points[4][1] = 0;	
		break;
		
		
		case 4 :
			points = new int[5][2];
	        points[0][0] = 25;
	        points[0][1] = 0;

	        points[1][0] = 75;
	        points[1][1] = 0;

	        points[2][0] = 75;
	        points[2][1] = 25;

	        points[3][0] = 25;
	        points[3][1] = 25;
	        
	        points[4][0] = 25;
	        points[4][1] = 0;	
		break;
		
		case 5 :
			points = new int[3][2];
	        points[0][0] = 25;
	        points[0][1] = 0;

	        points[1][0] = 25;
	        points[1][1] = 25;

	        points[2][0] = 0;
	        points[2][1] = 25;
		break;
		
		case 6 :
			points = new int[3][2];
	        points[0][0] = 100;
	        points[0][1] = 75;

	        points[1][0] = 75;
	        points[1][1] = 75;

	        points[2][0] = 75;
	        points[2][1] = 100;
		break;
		
		
		default:
			points = new int[5][2];
	        points[0][0] = 25;
	        points[0][1] = 25;

	        points[1][0] = 25;
	        points[1][1] = 35;

	        points[2][0] = 35;
	        points[2][1] = 35;

	        points[3][0] = 35;
	        points[3][1] = 25;

	        points[4][0] = 35;
	        points[4][1] = 35;
		}
		
		return points;
	
		
	}
	
	
}

