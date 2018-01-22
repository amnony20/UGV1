/*
 Copyright (c) 2007, Distributed Computing Group (DCG)
                    ETH Zurich
                    Switzerland
                    dcg.ethz.ch

 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:

 - Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.

 - Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the
   distribution.

 - Neither the name 'Sinalgo' nor the names of its contributors may be
   used to endorse or promote products derived from this software
   without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package projects.ugv.models.distributionModels;

import projects.defaultProject.models.distributionModels.Random;
import projects.ugv.Common;
import projects.ugv.Common.Walls;
import sinalgo.configuration.Configuration;
import sinalgo.nodes.Position;
import sinalgo.runtime.Main;
import sinalgo.tools.Tools;
import sinalgo.tools.statistics.Distribution;



/**
 * Places the Nodes randomly on the field using the Random-Distribution-Model but 
 * generating a new position if the simulation is using a map (useMap == true)
 * and there is a value greater than 0 in the map.
 */
public class ShortestPathRandomDistribution extends Random {
	
	
	private java.util.Random rand = Distribution.getRandom();
	private Common common = Common.getInstance();
	@Override
	public Position getNextPosition() {
		//Position pos = super.getNextPosition();
			Position pos = common.getWallPosition();
		if(Configuration.useMap){
			// anything else than white is considered an obstacle
			while(!Tools.getBackgroundMap().isWhite(pos)){
				pos = super.getNextPosition();
			}
		}
		return pos;
	}
	
	

}
