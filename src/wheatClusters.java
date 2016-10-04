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
			if ( c[i] < smallestDistance ){
				smallestDistance = c[i];
				index = i;
			}
		}
		
		return index;
	}
	
	
	public void resetCentroids(){
		wheat sumofWheats = new wheat(0,0,0,0,0,0,0);
		for ( ArrayList <wheat> al : clusters ){
			for( wheat w : al ){
				sumofWheats = wheat.add(sumofWheats, w);
				
			}
			
		}
			
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
