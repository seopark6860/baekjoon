import java.io.*;
import java.util.*;

public class Alg_7562 {
	static int[] dx= {1, 2, 2, 1, -1, -2, -2, -1};	// 오른쪽위 -> 시계방향
	static int[] dy= {2, 1, -1, -2, -2, -1, 1, 2};
	static int t, l;
	static int[][] chess;
	static boolean[][] v;
	static Queue<Node> q = new LinkedList<>();
	
	
	public static void printMap() {
		for(int i=0; i<l; i++) {
			for(int j=0; j<l; j++) {
				System.out.print(chess[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void solve() {
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0; i<8; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx<0 || nx>=l || ny<0 || ny>=l) continue;
				if(v[nx][ny]) continue;
				chess[nx][ny] = chess[node.x][node.y] + 1;
				q.add(new Node(nx, ny));
				v[nx][ny] = true;
			}
//			printMap();
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		t = Integer.parseInt(br.readLine());
		
		
		while(t-- > 0) {
			l = Integer.parseInt(br.readLine());
			chess = new int[l][l];
			v = new boolean[l][l];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			q.add(new Node(x, y));
			v[x][y] = true;
			
			st = new StringTokenizer(br.readLine());
			int dest_x = Integer.parseInt(st.nextToken());
			int dest_y = Integer.parseInt(st.nextToken());
			
			solve();
			System.out.println(chess[dest_x][dest_y]);
		}
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
