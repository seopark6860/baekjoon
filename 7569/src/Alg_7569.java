import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Alg_7569 {
	static int[] dx = { 0, 0, 0, 1, 0, -1 };	
	static int[] dy = { 0, 0, 1, 0, -1, 0 };
	static int[] dz = { 1, -1, 0, 0, 0, 0 };
	static int m, n, h;
	static int[][][] map;
//	static boolean[][][] visited;
	static Queue<Node> q;
	
	public static void bfs() {	
		while(!q.isEmpty()) {
			Node node = q.poll();
//			visited[node.z][node.x][node.y] = true;
			
			for(int i=0; i<6; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				int nz = node.z + dz[i];
				
				if(0<=nx && nx<n && 0<=ny && ny<m && 0<=nz && nz<h) {
//					if(map[nz][nx][ny] == 0 && !visited[nz][nx][ny]) {
					if(map[nz][nx][ny] == 0) {
						q.add(new Node(nz, nx, ny));
						map[nz][nx][ny] = map[node.z][node.x][node.y]+1;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		m = sc.nextInt();	// 행
		n = sc.nextInt();	// 열
		h = sc.nextInt();	// 면
		
		map = new int[h][n][m];		// 면 행 열
//		visited = new boolean[h][n][m];
		q = new LinkedList<Node>();
		
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					int x = sc.nextInt();
					map[k][i][j] = x;
					
					if(map[k][i][j] == 1)
						q.add(new Node(k, i, j));
				}
			}
		}
		bfs();
		
		int ans = 0;
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(ans < map[k][i][j]) {
						ans = map[k][i][j];
					}
					if (map[k][i][j] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(ans-1);
	}
}
class Node {
	int x;
	int y;
	int z;
	Node(int z, int x, int y){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}