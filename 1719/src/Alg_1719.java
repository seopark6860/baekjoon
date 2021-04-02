import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_1719 {
	static int INF = 1000000000;
	static int n, m;
	static int[][] arr;
	static int[][] path;
	
	public static void printMap() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(arr[i][j]==INF) {
					System.out.print("INF" + " ");
				} else {
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
					if(arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k]+arr[k][j];
						path[i][j] = path[i][k];
						
						
					}
				}
			}
			
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][n+1];
		path = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j) continue;
				arr[i][j] = INF;
			}
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[u][v] = arr[v][u] = c;
			path[u][v] = v;
			path[v][u] = u;
		}
		
//		printMap();
		solve();
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j){
					System.out.print("-" + " ");
				} else {
					System.out.print(path[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

}
