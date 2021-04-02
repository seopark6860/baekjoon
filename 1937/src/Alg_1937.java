import java.util.Scanner;

public class Alg_1937 {
	static int[] dx= {0, 1, 0, -1};
	static int[] dy= {1, 0, -1, 0};
	static int n;
	static int[][] map, dp;
	static boolean[][] visited;

	static void printMap() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.printf("%d ", dp[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	public static int dfs(int x, int y) {
		if(dp[x][y]!=0) return dp[x][y];
		
		dp[x][y] = 1;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0<=nx && nx<n && 0<=ny && ny<n) {
				if(map[x][y] < map[nx][ny]) {
					dp[x][y] = Math.max(dp[x][y], dfs(nx, ny)+1);
				}
			}
		}
		return dp[x][y];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		visited = new boolean[n][n];
		dp = new int[n][n];

		int max = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				max = Math.max(max, dfs(i, j));;
//				printMap();
			}
		}
		
		System.out.println(max);
	}

}
