import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Alg_7576 {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int m, n;
	static int[][] arr;
	static Queue<Node> q = new LinkedList<Node>();
	
	public static void bfs() {
		while(!q.isEmpty()) {
			Node node = q.poll();
		
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx<0 || nx>=n || ny<0 || ny>=m) 
					continue;
				if(arr[nx][ny] == 0) {
					q.add(new Node(nx, ny));
					arr[nx][ny] = arr[node.x][node.y] + 1;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		int zero = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1)
					q.add(new Node(i, j));
				if(arr[i][j] == 0)
					zero++;
			}
		}
		if(zero == 0) {			// 처음부터 모든 토마토 익어있다면 0출력
			System.out.println(0);
			return;
		}
		/*
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		*/
		bfs();
		/*
		System.out.println();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		*/
		int res = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				if(arr[i][j] >= 1)
					res = Math.max(res, arr[i][j]);
			}
		}
		System.out.println(res - 1);
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