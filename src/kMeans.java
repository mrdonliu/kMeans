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
				
				System.out.println("The closest cluster is " + wc.closestCluster(w));
				
				wc.getClusters().get(wc.closestCluster(w)).add(w);
				
				System.out.println("added dataset to cluster " + wc.closestCluster(w));
			}
			
			boolean changed = wc.resetCentroids();
			
			if ( !changed ){
				wc.setConvergence(true);
			}
				
		}
		
		
	}
	
	

}
