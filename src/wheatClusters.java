import java.util.ArrayList;

public class wheatClusters {
	private ArrayList<wheat>[] clusters;
	private boolean convergence;
	private wheat[] centroids;
	
	/**
	 * constructor that takes in three given centroids and assigns them. Each centroid is 
	 * with respect to the cluster of the same number. 
	 */
	public wheatClusters( wheat c0 , wheat c1 , wheat c2 ){
		clusters = new ArrayList[3];
		convergence = false;
		centroids = new wheat[3];
		centroids[0] = c0;
		centroids[1] = c1;
		centroids[2] = c2; 
	}

	public ArrayList<wheat>[] getClusters() {
		return clusters;
	}

	public void setClusters(ArrayList<wheat>[] clusters) {
		this.clusters = clusters;
	}

	public boolean isConvergence() {
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
