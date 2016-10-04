import java.util.ArrayList;
import java.util.Arrays;

public class kMeans {
	
	/**
	 * kmeans algorithm that returns clusters that have reached convergence.
	 * 
	 */
	public static wheatClusters kmeansAlg( wheatClusters wc , ArrayList<wheat> dataset ){
	
		
		while ( ! wc.isConverged() ){
			prevCentroids = Arrays.copyOf(wc.getCentroids(), 3);
			
			
			for ( wheat w : dataset ){
				for ( int i = 0 ; i < 3 ; i++ ){
					distances[i] = wheat.distance(w, prevCentroids[i] );
				}
				
				
				
			}
			
			
			
			
		}
		
	}
	
	

}
