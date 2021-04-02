import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Alg_2178 {
	static int[] dx= {0, 1, 0, -1};
	static int[] dy= {1, 0, -1, 0};
	static int[][] map;
	static boolean[][] visited;
	static int n, m;

	
	public static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx>=0 && ny>=0 && nx<n && ny<m) {
					if(map[nx][ny] == 1 && !visited[nx][ny]) {
						q.add(new Node(nx, ny));
						visited[nx][ny] = true;
						map[nx][ny] = map[node.x][node.y]+1;
					}
				}
			}
		}
	}
	/*
	public static void bfs(int x, int y) {
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		qx.add(x);
		qy.add(y);
		visited[x][y] = true;
		
		while(!qx.isEmpty() && !qy.isEmpty()) {
			x = qx.poll();
			y = qy.poll();
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx>=0 && ny>=0 && nx<n && ny<m) {
					if(map[nx][ny]==1 && !visited[nx][ny]) {
						qx.add(nx);
						qy.add(ny);
						visited[nx][ny] = true;
						map[nx][ny] = map[x][y]+1;
					}
				}
			}
		}
		
	}
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String str = sc.next();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		bfs(0, 0);
		System.out.print(map[n-1][m-1]);
	}
}
class Node {
	int x;
	int y;
	
	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
