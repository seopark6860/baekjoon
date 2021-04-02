import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Alg_1427 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split("");
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<str.length; i++) {
			list.add(str[i].charAt(0) - '0');
		}
		Collections.sort(list);
		for(int i=list.size()-1; i>=0; i--) {
			System.out.print(list.get(i));
		}
	}

}
