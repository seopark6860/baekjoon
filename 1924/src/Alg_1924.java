import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_1924 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		String[] arr = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		
		int sum = 0;
		for(int i=1; i<x; i++) {
			if(i == 2) {
				sum += 28;
			}
			else if(i == 4 || i == 6 || i == 9 || i == 11) {
				sum += 30;
			}
			else {
				sum += 31;
			}
		}
		int z = (sum + y) % 7;
		System.out.println(arr[z]);
	}

}
