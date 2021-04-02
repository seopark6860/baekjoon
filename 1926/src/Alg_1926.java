import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int x;
	int y;
	Node (int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}

public class Alg_1926 {
	static int[] dx= {1, 0, -1, 0};
	static int[] dy= {0, 1, 0, -1};
	static int n, m, max = 0;
	static int[][] arr;
	static boolean[][] visited;
	
	public static void solve(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		visited[x][y] = true;
		int sum = 1;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(int i=0; i<4; i++) {
				int nx = dx[i] + node.x;
				int ny = dy[i] + node.y;
				
				if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
				if(visited[nx][ny] || arr[nx][ny] == 0) continue;
				q.add(new Node(nx, ny));
				visited[nx][ny] = true;
				sum++;
			}
		}
		max = Math.max(max, sum);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 1 && !visited[i][j]) {
					solve(i, j);
					cnt++;
				}
			}
		}
//		if(cnt == 0) {
//			System.out.println(0);
//			return;
//		}
		System.out.println(cnt);
		System.out.println(max);
	}
}

