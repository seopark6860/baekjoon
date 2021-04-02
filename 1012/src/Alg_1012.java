import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Alg_1012 {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] map;
	static boolean[][] visited;
	static int m, n;
	static ArrayList<Integer> ans = new ArrayList<>();	// Áö··ÀÌ °³¼ö
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && ny>=0 && nx<m && ny<n) {
				if(map[nx][ny]==1 && visited[nx][ny]==false) {
					dfs(nx, ny);
				}
				
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t-- > 0) {
			m = sc.nextInt();
			n = sc.nextInt();
			int k = sc.nextInt();
		
			map = new int[m][n];
			
			for(int i=0; i<k; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
			
				map[u][v] = 1;	
			}
			
			visited = new boolean[m][n];
			int cnt=0;
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] == 1 && visited[i][j] == false) {
						dfs(i, j);
						cnt++;
					}
				}
			}	
			ans.add(cnt);
		}
		for(int i=0; i<ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}

}
