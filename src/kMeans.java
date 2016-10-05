import java.util.ArrayList;
import java.util.Arrays;

public class kMeans {
	
	/**
	 * kmeans algorithm that returns clusters that have reached convergence.
	 * 
	 */
	public static void kmeansAlg( wheatClusters wc , ArrayList<wheat> dataset ){
	
		
		while ( ! wc.isConverged() ){
			for( wheat w : dataset ){
				
				/**
				 * takes the cluster of wc, then gets the index of the closest cluster to w
				 * and accesses that cluster(arraylist). Then add w to that cluster. 
				 */
				wc.getClusters().get(wc.closestCluster(w)).add(w);
			}
			
			if ( !wc.resetCentroids() ){
				wc.setConvergence(true);
			}
				
		}
		
		
	}
	
	

}
