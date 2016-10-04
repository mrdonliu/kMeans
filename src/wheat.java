import java.util.ArrayList;

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
	

}
