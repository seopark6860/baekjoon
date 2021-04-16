import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_11053 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[n + 1];
		dp[1] = 1;
		int max = 1;
		for(int i=2; i<=n; i++) {
			dp[i] = 1;
			for(int j=1; j<i; j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
			if(max < dp[i])
				max = dp[i];
		}
		System.out.println(max);
	}
}