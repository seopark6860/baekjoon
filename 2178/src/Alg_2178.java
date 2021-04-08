import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Alg_2178 {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int n, m;
	static int[][] miro;
	static boolean[][] visited;
	
	public static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(x, y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if(miro[nx][ny] == 1 && !visited[nx][ny]) {
						q.add(new Node(nx, ny));
						visited[nx][ny] = true;
						miro[nx][ny] = miro[node.x][node.y] + 1;
					}
				}
				
			}
		}
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		miro = new int[n][m];
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split("");
			for(int j=0; j<m; j++) {
				miro[i][j] = Integer.parseInt(str[j]);
			}
		}
		visited = new boolean[n][m];
		bfs(0, 0);
		System.out.println(miro[n - 1][m - 1]);
	}
}
class Node {
	int x;
	int y;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}