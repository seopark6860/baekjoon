import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_15486 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n + 2][2];
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());	// 상담기간
			arr[i][1] = Integer.parseInt(st.nextToken());	// 돈
		}
		int[] dp = new int[n + 2];		// i일 째 상담의 최대비용
		
		int sum = 0;
		for(int i=1; i<=n + 1; i++) {
			sum = Math.max(sum, dp[i]);
			if(i + arr[i][0] > n + 1)
				continue;
			dp[i + arr[i][0]] = Math.max(dp[i + arr[i][0]], sum + arr[i][1]); 
		}
		System.out.println(sum);
	}

}
