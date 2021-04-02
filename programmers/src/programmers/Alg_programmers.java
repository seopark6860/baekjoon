package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Alg_programmers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"} ;
        String answer = "";
        
        Map<String, Integer> hash = new HashMap<>();

        for(String part : participant) {
        	hash.put(part, hash.getOrDefault(part, 0) + 1);
        }
        for(String comp : completion) {
        	hash.put(comp, hash.get(comp) - 1);
        }
        for(Entry<String, Integer> entry : hash.entrySet()) {
        	if(entry.getValue() > 0) {
        		answer = entry.getKey();
        		break;
        	}
        }
	}
}
