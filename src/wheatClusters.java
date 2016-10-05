import java.util.ArrayList;

public class wheatClusters {
	//private ArrayList<wheat>[] clusters;
	private ArrayList<ArrayList<wheat>> clusters;
	private boolean convergence;
	private wheat[] centroids;
	
	
	/**
	 * constructor that takes in three given centroids and assigns them. Each centroid is 
	 * with respect to the cluster of the same number. 
	 */
	public wheatClusters( wheat c0 , wheat c1 , wheat c2 ){
		clusters = new ArrayList<>(3);
		for ( int i = 0 ; i < 3 ; i++){
			clusters.add(new ArrayList<wheat>() );
		}
		
		convergence = false;
		centroids = new wheat[3];
		
		centroids[0] = c0;
		centroids[1] = c1;
		centroids[2] = c2; 
	
	}


	/**
	 * Takes an array of clusters, where index represents cluster number, and element
	 * represents distances from dataset to that cluster. Returns the closest cluster's number. 
	 */
	public int closestCluster( wheat w ){
		
	
		double[] distances = new double[3];
		
		for ( int i = 0 ; i < 3 ; i++ ){
			distances[i] = wheat.distance(w, centroids[i] );
		}
		
		double smallestDistance = distances[0];
		int index = 0;
		
		for ( int i = 1 ; i < 3 ; i++ ){
			if ( distances[i] < smallestDistance ){
				smallestDistance = distances[i];
				index = i;
			}
		}
		
		return index;
	}
	
	/**
	 * resets centroids based on potentially new cluster sets. Returns true
	 * if the centroids were changed, and false if they remained the same.
	 */
	public boolean resetCentroids(){
		wheat sumofWheats;
		wheat[] newCentroids = new wheat[3];
		
		for ( int i = 0 ; i < 3 ; i++ ){
			sumofWheats = new wheat(0,0,0,0,0,0,0);
			
			for ( int x = 0 ; x < clusters.get(i).size() ; x++ ){
				sumofWheats = wheat.add( sumofWheats , clusters.get(i).get(x) );
				
			}
			
			newCentroids[i] = wheat.division(sumofWheats , clusters.get(i).size() );
		}
		
		for ( int z = 0 ; z < 3 ; z++ ){
			if ( newCentroids[z] != centroids[z] ) return true;
		}
		
		return false;
			
	}
	
	
	
	public ArrayList<ArrayList<wheat>> getClusters() {
		return clusters;
	}

	public void setClusters(ArrayList<ArrayList<wheat>> clusters) {
		this.clusters = clusters;
	}

	public boolean isConverged() {
		return convergence;
	}

	public void setConvergence(boolean convergence) {
		this.convergence = convergence;
	}

	public wheat[] getCentroids() {
		return centroids;
	}

	public void setCentroids(wheat[] centroids) {
		this.centroids = centroids;
	}
	
	
	
	
	
	

}
