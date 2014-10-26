package Random;

import java.util.ArrayList;
import java.util.List;

public class AllSubsets {
	public static void main(String args[]){
		generateAllSubsets("tanm");
	}

	public static void generateAllSubsets(String data){
		List<String> answer = new ArrayList<String>();
		answer.add("");
		for(int i = 0; i < data.length(); i++){
			List<String> tmp = new ArrayList<String>();
			for(String al : answer){
				tmp.add(al + data.charAt(i));
			}
			answer.addAll(tmp);
			System.out.println(answer);
		}
	}
}
