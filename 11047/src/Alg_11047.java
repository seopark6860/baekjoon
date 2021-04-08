import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_11047 {
	static int n, k, res = 0;
	static int[] coin;
	
	public static void solve() {
		for(int i= n - 1; i>=0; i--) {
			if(k >= coin[i]) {
				res += k / coin[i];
				k %= coin[i];
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		coin = new int[n];
		
		for(int i=0; i<n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		solve();
		System.out.println(res);
	}

}
