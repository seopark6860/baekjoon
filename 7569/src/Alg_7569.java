import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Alg_7569 {
	static int[] dx= {0, 1, 0, -1, 0, 0};	// 위, 오, 아래, 왼, 앞, 뒤
	static int[] dy= {1, 0, -1, 0, 0, 0};
	static int[] dz= {0, 0, 0, 0, 1, -1};
	static int m, n, h;
	static int[][][] arr;
	static Queue<Node> q = new LinkedList<Node>();
	
	public static void printMap() {
		for(int k=0; k<h; k++) {
			for(int z=0; z<n; z++) {
				for(int j=0; j<m; j++) {
					System.out.print(arr[k][z][j]);
				}
				System.out.println();
			}
		}
	}
	public static void bfs() {
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0; i<6; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				int nz = node.z + dz[i];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h)
					continue;
				if(arr[nz][nx][ny] == 0) {
					q.add(new Node(nz, nx, ny));
					arr[nz][nx][ny] = arr[node.z][node.x][node.y] + 1;
				}
//				printMap();
//				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		arr = new int[h][n][m];
		int zero = 0;
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<m; j++) {
					arr[k][i][j] = Integer.parseInt(st.nextToken());
					if(arr[k][i][j] == 1) {
						q.add(new Node(k, i, j));
					}
					if(arr[k][i][j] == 0)
						zero++;
				}
			}
		}
		if(zero == 0) {
			System.out.println(0);
			return ;
		}
		
		bfs();
//		printMap();
		int max = 0;
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(arr[k][i][j] == 0){
						System.out.println(-1);
						return;
					}
					max = Math.max(max, arr[k][i][j]);
				}
			}
		}
		System.out.println(max - 1);
	}
}
class Node {
	int z;
	int x;
	int y;
	Node(int z, int x, int y){
		this.z = z;
		this.x = x;
		this.y = y;
	}
}