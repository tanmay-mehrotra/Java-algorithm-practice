package Random;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class DataCenterCapacity {
	public static void main(String args[]){
		System.out.println(calculateCapacity(getInput()));
	}

	/*
	 * function to accept input form user and return 
	 * the input in form of a 2D-array.
	 */
	static public int[][] getInput(){
		Scanner s = new Scanner(System.in);
		String m_n = s.nextLine();
		int m = Integer.parseInt(m_n.split("\\s+")[0]);
		int n = Integer.parseInt(m_n.split("\\s+")[1]);
		int nodes[][] = new int[m][n];
		for(int i = 0; i<m; i++){
			String versions[] = s.nextLine().split("\\s+");
			for(int j = 0; j < n; j++){
				nodes[i][j]=Integer.parseInt(versions[j]);
			}
		}
		s.close();
		return nodes;
	}
	
	/*
	 * function to calculate Capacity  
	 */
	static public int calculateCapacity(int[][] nodes){
		int m = nodes.length;
		int n = nodes[0].length;

		Map<Integer,Integer> tmpFrequencyOfVersions = new HashMap<Integer,Integer>(n+1,1);
		Map<Integer, Integer> frequencyOfversions = new HashMap<Integer,Integer>(n+1,1);

		//generate freq map of versions for the first column
		for(int row = 0 ;row < m; row++){
			if(frequencyOfversions.containsKey(nodes[row][0])){
				frequencyOfversions.put(nodes[row][0], frequencyOfversions.get(nodes[row][0])+1);
			}else{
				frequencyOfversions.put(nodes[row][0], 1);
			}
		}

		//here we calculate frequency map for all the columns one at a time
		for(int col = 1 ; col < n; col++){
			for(int row=0 ; row <m ; row++){

				if(tmpFrequencyOfVersions.containsKey(nodes[row][col])){
					tmpFrequencyOfVersions.put(nodes[row][col], tmpFrequencyOfVersions.get(nodes[row][col])+1);
				}else{
					tmpFrequencyOfVersions.put(nodes[row][col], 1);
				}
			}

			/*
			 * based on the temperory frequeny map prepared above we update our frequencyOfversions map
			 * based on the following rule:
			 * 1. for a key present in frequencyOfversions we update its value 
			 *     - if same key is present in tmpFrequencyOfVersions and has value lower than value in frequencyOfversions
			 *     	 then update with this lower value
			 *     - if value is equal or higher then take no action
			 * 2. if a key is present in frequencyOfversions and not in tmpFrequencyOfVersions
			 *     - delete that entry from frequencyOfversions map
			 */
			Iterator<Map.Entry<Integer,Integer>> iterator = frequencyOfversions.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Integer, Integer> entry = iterator.next();
				if(tmpFrequencyOfVersions.containsKey(entry.getKey())){
					if(tmpFrequencyOfVersions.get(entry.getKey())<entry.getValue()){
						entry.setValue(tmpFrequencyOfVersions.get(entry.getKey()));
					}
				}else{
					iterator.remove();
				}
			}
			
			//check if there are entries left in frequencyOfversions, if not return zero
			if(frequencyOfversions.size() == 0 ){
				return 0;
			}
			
			//clear tmpFrequencyOfVersions and reuse it for next iteration
			tmpFrequencyOfVersions.clear();
		}

		return sumAllFrequencies(frequencyOfversions)*100;
	}

	/*
	 * function to sum all values present in frequencyOfversions
	 */
	public static int sumAllFrequencies(Map<Integer,Integer> frequencyOfversions){
		int totalCapacity = 0;
		for(Entry<Integer, Integer> entry : frequencyOfversions.entrySet()){
			totalCapacity+=entry.getValue();
		}
		return totalCapacity;
	}
}