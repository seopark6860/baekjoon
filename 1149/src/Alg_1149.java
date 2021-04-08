import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_1149 {
	static int n;
	static int[][] arr;		// 초기값
	static int[][] dp;		// 각 집의 최소값 저장
	 
	public static int solve(int house, int color) {
		if(house == 1)
			return dp[house][color];
		if(dp[house][color] > 0) {
			return dp[house][color];
		}
		else {
			if(color == 0)
				dp[house][color] = Math.min(solve(house - 1, 1), solve(house - 1, 2)) + arr[house][0];
			else if(color == 1)
				dp[house][color] = Math.min(solve(house - 1, 0), solve(house - 1, 2)) + arr[house][1];
			else
				dp[house][color] = Math.min(solve(house - 1, 0), solve(house - 1, 1)) + arr[house][2];
		}
		return dp[house][color];
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][3];
		
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		dp = new int[n + 1][3];
		dp[1][0] = arr[1][0];
		dp[1][1] = arr[1][1];
		dp[1][2] = arr[1][2];
		
//		solve(n, 0);
//		solve(n, 1);
//		solve(n, 2);
		
		for(int i=2; i<=n; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
		}
		System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
	}
}
