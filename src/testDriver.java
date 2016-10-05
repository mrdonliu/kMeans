import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class testDriver {
	
	public static void main( String[] args ){
		ArrayList<wheat> dataset = new ArrayList<>();
		String[] split;  // splitting text into separate attributes
		double[] a = new double[7]; // parsing the attributes into doubles
		
		try {
			BufferedReader br = new BufferedReader( new FileReader("seeds_dataset.txt") );
			String line = null;
			
			
			try {
				while( (line = br.readLine()) != null ){
					split = line.split("\\s+");
					for( int i = 0 ; i < 7 ; i++ ){
						a[i] = Double.parseDouble( split[i] );
					}
					
					dataset.add(new wheat(a[0] , a[1] , a[2] , a[3] , a[4] , a[5] , a[6] ) );
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Random r = new Random();
		//wheatClusters wc = new wheatClusters( dataset.get(r.nextInt(211)) , dataset.get(r.nextInt(211)) , dataset.get(r.nextInt(211)) );
		System.out.println("intial dataset:");
		dataset.get(23).print();
		dataset.get(172).print();
		dataset.get(135).print();
		
		wheatClusters wc = new wheatClusters( dataset.get(23) , dataset.get(172) , dataset.get(135) );
		kMeans.kmeansAlg(wc, dataset);
		System.out.println("done");

	}

}
