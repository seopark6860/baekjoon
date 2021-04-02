import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx= {0, 1, 0, -1};
	static int[] dy= {1, 0, -1, 0};
	static int n, cnt=0;
	static int[][] map;
	static int[][] bridge;
	static boolean[][] visited;
	static Queue<Node> q = new LinkedList<>();
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void printMap() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(bridge[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void solve() {
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = node.x+dx[i];
				int ny = node.y+dy[i];
				
				if(0<=nx && nx<n && 0<=ny && ny<n) {
					if(map[nx][ny]!=0 && map[nx][ny]!=map[node.x][node.y]) {
						list.add(bridge[nx][ny]+bridge[node.x][node.y]);
					}
					if(map[nx][ny]==0) {
						q.add(new Node(nx, ny));
						map[nx][ny] = map[node.x][node.y];
						bridge[nx][ny] = bridge[node.x][node.y]+1;
					}
					
				}
			}
		}
	}
	
	public static void land_cnt(int x, int y, int land) {
		if(visited[x][y])
			return;
		visited[x][y] = true;
		map[x][y] = land;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(0<=nx && nx<n && 0<=ny && ny<n) {
				if(map[nx][ny]==1 && !visited[nx][ny]) {
					map[nx][ny] = land;
					land_cnt(nx, ny, land);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		bridge = new int[n][n];
		// ÀÔ·Â
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[n][n];
		int land = 1;
		// ¼¶ ³Ñ¹ö¸µ
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					land_cnt(i, j, land++);		
				}
			}
		}

		// ¼¶ÀÇ ÀÎµ¦½º Å¥¿¡ ÀúÀå
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]!=0) {
					q.add(new Node(i, j));
				}
			}
		}
		solve();
		
		int ans = Integer.MAX_VALUE;
		for(int i : list) {
			if(ans > i) {
				ans = i;
			}
		}
		System.out.println(ans);
//		printMap(); 
	}
}
class Node {
	int x, y;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}