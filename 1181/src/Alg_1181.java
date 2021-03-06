import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Alg_1181 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<String> list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			list.add(str);
		}		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if(o1.length() > o2.length())
					return 1;
				else if(o1.length() < o2.length())
					return -1;
				else {
					return o1.compareTo(o2);
				}
			}
		});
		System.out.println(list.get(0));
		for(int i=1; i<n; i++) {
			if(list.get(i).equals(list.get(i-1)))
				continue;
			System.out.println(list.get(i));
		}
	}

}
