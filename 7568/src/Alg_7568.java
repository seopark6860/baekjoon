import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_7568 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] h = new int[n];
		int[] w = new int[n];
		int[] res = new int[n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h[i] = Integer.parseInt(st.nextToken());
			w[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<n; i++) {
			int cnt = 0;
			for(int j=0; j<n; j++) {
				if(i == j)
					continue;
				if(h[i] < h[j] && w[i] < w[j]) {
					cnt++;
					res[i] = cnt + 1;
				}
			}
		}
		for(int i : res) {
			if(i == 0)
				System.out.print(1 + " ");
			else
				System.out.print(i + " ");
		}
	}

}
