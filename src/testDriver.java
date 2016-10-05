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
		int r1,r2,r3;
		r1 = r.nextInt(211);
		r2 = r.nextInt(211);
		r3 = r.nextInt(211);
		wheatClusters wc = new wheatClusters( dataset.get(r.nextInt(211)) , dataset.get(r.nextInt(211)) , dataset.get(r.nextInt(211)) );
		System.out.println("intial dataset:");

		
		//wheatClusters wc = new wheatClusters( dataset.get(50) , dataset.get(34) , dataset.get(209) );
		kMeans.kmeansAlg(wc, dataset);
		dataset.get(r1).print();
		dataset.get(r2).print();
		dataset.get(r3).print();
		System.out.println("done");
		
		
		for ( int x = 0 ; x < 3 ; x++ ){
			wc.getCentroids()[x].print();
		}
		
		double iv = kMeans.iV(wc);
		double ev = kMeans.eV(wc);
		double ivOverEv = kMeans.iV(wc) / kMeans.eV(wc);
		System.out.println(iv+" " + ev+ " " + ivOverEv);

	}

}
