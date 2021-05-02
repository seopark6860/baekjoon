import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_12865 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] bag = new int[n + 1][2];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			bag[i][0] = Integer.parseInt(st.nextToken());	// 무게
			bag[i][1] = Integer.parseInt(st.nextToken());	// 가치
		}
		int[][] dp = new int[n + 1][k + 1];	
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=k; j++) {
				if(j - bag[i][0] >= 0) {		// i번째 물건 넣을 수 있을 때
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - bag[i][0]] + bag[i][1]);
				}
				else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[n][k]);
	}
}