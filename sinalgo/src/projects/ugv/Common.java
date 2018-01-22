package projects.ugv;

import sinalgo.configuration.Configuration;
import sinalgo.nodes.Position;
import sinalgo.runtime.Main;
import sinalgo.tools.statistics.Distribution;

public class Common {
	public enum Walls {
		NORTH,SOUTH,WEST,EAST
	}
	
	private static final Common common = new Common();
	
	 private Common(){}
	 
	private java.util.Random rand = Distribution.getRandom();
	
	public Position getWallPosition() {
		
		Walls wall = getRandomWall(); 
		
		double randomPosX = rand.nextDouble() * Configuration.dimX;
		double randomPosY = rand.nextDouble() * Configuration.dimY;
		double randomPosZ = 0;
		
		if(Main.getRuntime().getTransformator().getNumberOfDimensions() == 3) {
			randomPosZ = rand.nextDouble() * Configuration.dimZ;
		}
		switch (wall) {
		case NORTH:
			randomPosY = Configuration.dimY;
			break;
		case SOUTH:
			randomPosY = 0;
			break;
		case WEST:
			randomPosX = 0;
				break;
		case EAST: 
			randomPosX = Configuration.dimX;	
				break;
		default:
			break;
		}
		Position pos =  new Position(randomPosX, randomPosY, randomPosZ);
		return pos;
	}
	private Walls getRandomWall() {
		java.util.Random rand = Distribution.getRandom();
		Walls wall = Walls.values()[Math.abs(rand.nextInt()%4)];
		return wall;
	}
	public static Common getInstance() {
		// TODO Auto-generated method stub
		return common;
	}
	

}
