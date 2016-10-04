import java.util.ArrayList;
import java.util.Arrays;

public class wheat {
	
	private Double[] attributes;
	
	public wheat( double area , double perimeter , double compactness , double kernalLength , 
			      double kernelWidth , double asymCoefficient , double grooveLength ){
		attributes = new Double[7];
		attributes[0] = area;
		attributes[1] = perimeter;
		attributes[2] = compactness;
		attributes[3] = kernalLength;
		attributes[4] = kernelWidth;
		attributes[5] = asymCoefficient;
		attributes[6] = grooveLength;
	}
	
	public Double[] getAttributes(){ return attributes; }
	public void setAttributes( Double[] attributes ){ this.attributes = attributes; }

	/**
	 * The euclidean distance between two wheat objects.
	 */
	public static double distance ( wheat w1 , wheat w2 ){
		double sum = 0;
		for ( int i = 0 ; i < 7 ; i++ ){
			sum += Math.pow( w1.getAttributes()[i] - w2.getAttributes()[i] , 2);
		}
		
		return Math.sqrt(sum);
	}
	
	
	/**
	 * Used within the kMeans class kmeansAlg method. It's used to check if new
	 * centroid is equal to the old centroid. If all three centroids are unchanged,
	 * convergence is reached, and the kmeans algorithm ends. 
	 */
	public boolean equals( wheat w1 , wheat w2 ){
		return ( Arrays.equals(w1.getAttributes(), w2.getAttributes() ) );
		
	}
	
	public static wheat add( wheat w1 , wheat w2 ){
		double[] a = new double[7]; // new attributes
		for( int i = 0 ; i < 7 ; i++ ){
			a[i] = w1.getAttributes()[i] + w2.getAttributes()[i];	
		}
		
		return new wheat(a[0] , a[1] , a[2] , a[3] , a[4] , a[5] , a[6] );
		
	}
	
	public static wheat division( wheat w , int x ){
		
		double[] a = new double[7]; // new attributes
		for( int i = 0 ; i < 7 ; i++ ){
			a[i] = a[i] / x;
		}
		
		return new wheat(a[0] , a[1] , a[2] , a[3] , a[4] , a[5] , a[6] );
		
		
	}
	

}
