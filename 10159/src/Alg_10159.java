import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_10159 {
	static int INF = 1000000000;
	static int n, m;
	static int[][] arr;
	
	public static void printMap() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(arr[i][j] == 1000000000) {
					System.out.print(-1 + " ");
				}
				else {
					System.out.print(arr[i][j] + " ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void solve() {
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(arr[i][k]==1 && arr[k][j]==1) {
						arr[i][j] = 1;
					}
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		arr = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j) continue;
				arr[i][j] = INF;
			}
		}
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			arr[u][v] = 1;
		}
		printMap();
		solve();
		printMap();
		
		for(int i=1; i<=n; i++) {
			int ans = 0;
			for(int j=1; j<=n; j++) {
				if(arr[i][j]==INF && arr[j][i]==INF)
					ans++;
			}
			System.out.printf("%d\n", ans);
		}
	}

}
