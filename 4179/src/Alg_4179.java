import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Alg_4179 {
	static int[] dx= {1, 0, -1, 0};
	static int[] dy= {0, 1, 0, -1};
	static int r, c;
	static String[][] map;
	static boolean ans;
	static int[][] dist1;
	static int[][] dist2;
	static Queue<Node> jq = new LinkedList<Node>();
	static Queue<Node> fq = new LinkedList<Node>();
	
	public static void solve1(Queue<Node> q, int[][] dist) {
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx<0 || nx>=r || ny<0 || ny>=c) continue;
				if(map[nx][ny].equals("#")) continue;
				if(dist[nx][ny] != 0) continue;
				dist[nx][ny] = dist[node.x][node.y] + 1;
				q.add(new Node(nx, ny));
			}
		}
	}
	public static void solve2(Queue<Node> q, int[][] dist) {
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx<0 || nx>=r || ny<0 || ny>=c) {
					System.out.println(dist[node.x][node.y] + 2);
					ans = true;
					return;
				}
				if(map[nx][ny].equals("#") || dist[nx][ny] > 0) continue;
				if(dist[n)
				dist[nx][ny] = dist[node.x][node.y] + 1;
				q.add(new Node(nx, ny));
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		r = Integer.parseInt(input[0]);
		c = Integer.parseInt(input[1]);
		
		map = new String[r][c];
		for(int i=0; i<r; i++) {
			input = br.readLine().split("");
			for(int j=0; j<c; j++) {
				map[i][j] = input[j];
				if(map[i][j].equals("J"))
					jq.add(new Node(i, j));
				if(map[i][j].equals("F"))
					fq.add(new Node(i, j));
			}
		}
		dist1 = new int[r][c];
		dist2 = new int[r][c];
		solve2(fq, dist2);
		solve1(jq, dist1);
		if(ans)
			return;
		else
			System.out.println("IMPOSSIBLE");
		/*
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				System.out.print(dist2[i][j]);
			}
			System.out.println();
		}
		*/
		
	}

}

class Node {
	int x;
	int y;
	Node (int x, int y){
		this.x = x;
		this.y = y;
	}
}