import java.util.Arrays;
import java.util.Scanner;

public class Alg_2667 {
	static int[] dx= {0, 1, 0, -1};
	static int[] dy= {1, 0, -1, 0};
	static int[][] map;
	static boolean[][] visited;
	static int[] apart;
	static int n, cnt=1;	// 아파트 단지 수
	
	static void dfs(int x, int y) {
		if(visited[x][y])
			return;
		
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0<=nx && nx<n && 0<=ny && ny<n) {
				if(map[nx][ny] == 1 && !visited[nx][ny]) {
					map[nx][ny] = cnt;
					dfs(nx, ny);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			String str = sc.next();
			for(int j=0; j<n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		visited = new boolean[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					map[i][j] = cnt;
					dfs(i, j);
					cnt++;		
				}
			}
		}
		apart = new int[cnt];	
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] != 0) {
					apart[map[i][j]]++;
				}
			}
		}
		Arrays.sort(apart);
		
		System.out.println(cnt-1);
		for(int i=1; i<apart.length; i++) {
			System.out.println(apart[i]);
		}
		
	}

}
