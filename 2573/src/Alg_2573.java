import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Alg_2573 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int n, m;
	static int[][] map;
	static int[][] ice;
	static boolean[][] visited;
	static Queue<Node> q = new LinkedList<>();

	public static void printMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void solve() {
		int year = 0;
		while (true) {
			visited = new boolean[n][m];
			ice = new int[n][m];
			
			// ºù»ê µ¢¾î¸® °³¼ö
			int cnt = 0;
			for (int i = 1; i < n; i++) {
				for (int j = 1; j < m; j++) {
					if (map[i][j] != 0) {
						q.add(new Node(i, j));
					}
					if (map[i][j] != 0 && !visited[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			if (cnt == 0) {
				System.out.println(0);
				return;
			}
			if (cnt >= 2) {
				System.out.println(year);
				return;
			}
			year++;

			melt();
		}

	}

	public static void dfs(int x, int y) {
		if (visited[x][y])
			return;
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 <= nx && nx < n && 0 <= ny && ny < m) {
				if (map[nx][ny] != 0 && !visited[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}
	public static void melt() {
		int size = q.size();

		while (size-- > 0) {
			Node node = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];

				if (0 <= nx && nx < n && 0 <= ny && ny < m) {
					if (map[nx][ny] == 0) {
						ice[node.x][node.y]++;
					}
				}
			}
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				map[i][j] -= ice[i][j];
				if (map[i][j] < 0) {
					map[i][j] = 0;
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve();
	}
}

class Node {
	int x, y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}