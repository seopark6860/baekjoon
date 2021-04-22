import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_1890 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/*
		for(int i=1; i<=n ;i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		*/
		long[][] dp = new long[n][n];
		dp[0][0] = 1;
		for(int i = 0; i<n; i++) {
		       for(int j = 0; j<n; j++) {
		    	   if(i == n - 1 && j == n - 1)
		    		   continue;
		           // 오른쪽으로 이동
		    	   if(j + arr[i][j] < n)
		    		   dp[i][j + arr[i][j]] += dp[i][j];
		    	   // 왼쪽으로 이동
		    	   if(i + arr[i][j] < n)
		    		   dp[i + arr[i][j]][j] += dp[i][j];
		       }
		}
		System.out.println(dp[n - 1][n - 1]);
	}
}
