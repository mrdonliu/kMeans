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
	
	
	public static double iV( wheatClusters wc ){
		
		double sum = 0;
		for ( int i = 0 ; i < 3 ; i++ ){
			for ( int x = 0 ; x < wc.getClusters().get(i).size() ; x++ ){
				sum += wheat.distance(wc.getClusters().get(i).get(x) , wc.getCentroids()[i] );
				
			}
			
		}
		
		return sum;
		
	}
	
	public static double eV( wheatClusters wc ){
		double sum = 0;
		
		for ( int i = 0 ; i < wc.getClusters().get(2).size(); i++ ){
			for ( int x = 0 ; x < 2 ; x++ ){
				for ( int z = 0 ; z < wc.getClusters().get(x).size(); z++ ){
					sum += wheat.distance( wc.getClusters().get(2).get(i), wc.getClusters().get(x).get(z) );
				}
				
			}
		}
		
		int numofElems = 0;
		
		for ( int b = 0 ; b < 3 ; b++ ){
			numofElems += wc.getClusters().get(b).size();
		}
		
		return sum / numofElems;
		
	}
	
	

}
