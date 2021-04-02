import java.util.Scanner;

public class Alg_14503 {
	static int[] dx = { -1, 0, 1, 0 };	// 북동남서
	static int[] dy = { 0, 1, 0, -1 };
	static int n, m;
	static int[][] map;
	static int rotation = 0, ans = 0;
	
	public static void printMap() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void dfs(int r, int c, int d) {
		map[r][c] = 2;
//		printMap();
		int nx, ny;
		for(int i=0; i<4; i++) {
			if (d == 0)
				d = 3;
			else
				d--;
			nx = r + dx[d];
			ny = c + dy[d];
			
			if(0<=nx && nx<n && 0<=ny && ny<m && map[nx][ny]==0) {
				// 왼쪽이 청소가 가능한 경우
				ans++;
				dfs(nx, ny, d);
				return;
			}
		}
		// 후진
		nx = r - dx[d];
		ny = c - dy[d];
		if(0<=nx && nx<n && 0<=ny && ny<m && map[nx][ny]!=1) {
			dfs(nx, ny, d);
		}
		
	}
	// 청소할 수 있는 자리인지 체크
	public static void clean(int r, int c, int d) {
		map[r][c] = 2;
		ans++;

		while (true) {
			printMap();
			if (rotation == 4) {
				int nx = r - dx[d];
				int ny = c - dy[d];
				
				if(map[nx][ny] == 1) {
//					System.out.println(ans);
					return;
				} else {
					r = nx;
					c = ny;
					continue;
				}
			}
			// 왼쪽방향으로 변경
			if (d == 0)
				d = 3;
			else
				d--;
			rotation++; // 방향변경 횟수 증가

			int nx = r + dx[d];
			int ny = c + dy[d];
			if (map[nx][ny] == 0) { // 왼쪽이 0이면
				r = nx;
				c = ny;
				map[nx][ny] = 2;
				ans++;
				rotation=0;
				continue;
			} else if (map[nx][ny] == 1 || map[nx][ny] == 2) { // 왼쪽이 벽이거나 청소한 곳이면
				//네 방향 확인
				for(int i=0; i<4; i++) {
					int x = r + dx[i];
					int y = c + dy[i];
					
					// 4방향이 벽이거나 청소해야 될 경우
				}
				r = r - dx[d];
				c = c - dy[d];
				continue;
			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		dfs(r, c, d);
		System.out.println(ans+1);

	}
}
