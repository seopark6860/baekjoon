import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 2178 */
public class Main {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int n, m, ans = 0;
	static int[][] map;
	static boolean[][] visited;

	public static void bfs(int x, int y) {
		Queue<Miro> q = new LinkedList<Miro>();
		q.add(new Miro(x, y));

		while (!q.isEmpty()) {
			Miro miro = q.poll();
			visited[x][y] = true;
			
			for (int i = 0; i < 4; i++) {
				int nx = miro.x + dx[i];
				int ny = miro.y + dy[i];
			
				if (0 <= nx && nx < n && 0 <= ny && ny < m) {
					if (map[nx][ny] == 1 && !visited[nx][ny]) {
						map[nx][ny] = map[miro.x][miro.y] + 1;
						q.add(new Miro(nx, ny));
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String str = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		bfs(0, 0);
		System.out.println(map[n-1][m-1]);
	}

}

class Miro {
	int x;
	int y;

	Miro(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
