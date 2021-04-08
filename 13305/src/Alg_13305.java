import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_13305 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[] len = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<n; i++) {
			len[i] = Integer.parseInt(st.nextToken());
		}
		
		long[] cost = new long[n + 1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		long res = len[1] * cost[1];
		long min = cost[1];
		for(int i=2; i<n; i++) {
			if(cost[i] < min) {
				min = cost[i];
				res += (min * len[i]);
				continue;
			}
			res += (min * len[i]);
		}
		System.out.println(res);
	}

}