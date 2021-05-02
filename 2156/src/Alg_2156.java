import java.io.*;

public class Alg_2156 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n + 1];
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int[][] dp = new int[n + 1][3];
		dp[1][0] = 0;		// ¾È ¸¶¼ÌÀ» ¶§
		dp[1][1] = arr[1];	// ÇÑÀÜ Â° ¸¶¼ÌÀ» ¶§
		dp[1][2] = arr[1];	// ¿¬´Þ¾Æ µÎ¹øÂ° ÀÜ ¸¶¼ÌÀ» ¶§ 

		for(int i=2; i<=n; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
			dp[i][1] = dp[i - 1][0] + arr[i];
			dp[i][2] = dp[i - 1][1] + arr[i];
		}
		System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
	}
	
}