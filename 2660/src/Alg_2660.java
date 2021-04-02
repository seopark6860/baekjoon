import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Alg_2660 {
	static int INF = 1000000000;
	static int n;
	static int[][] d;
	
	public static void floyd() {
		
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(d[i][j] > d[i][k] + d[k][j]) {
						d[i][j] = d[i][k] + d[k][j] ;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		d = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j) continue;
				d[i][j] = INF;
			}
		}
		
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a==-1 && b==-1) break;
			
			d[a][b] = 1;
			d[b][a] = 1;
		}
		
		floyd();
		
		int[] ans = new int[n+1];
		int score = n;
		for(int i=1; i<=n; i++) {
			int max = 0;
			for(int j=1; j<=n; j++) {
				max = Math.max(max, d[i][j]);
			}
			ans[i] = max;
			score = Math.min(score, ans[i]);
		}
		
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=1; i<=n; i++) {
			if(ans[i] == score)
				arr.add(i);
		}
		
		System.out.printf("%d %d", score, arr.size());
		System.out.println();
		Collections.sort(arr);
		for(int i=0; i<arr.size(); i++) {
			System.out.printf("%d ", arr.get(i));
		}
		
	}

}