import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Alg_1292 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		ArrayList<Integer> arr = new ArrayList<>();
		int sum = 0;
		for(int i=1; i<=b; i++) {
			int n = 0;
			while(n < i) {
				arr.add(i);
				n++;
			}
			if(a<=i && i<=b) {
				sum += arr.get(i-1);
			}
		}
		System.out.println(sum);
	}

}
