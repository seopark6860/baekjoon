import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//import java.util.Scanner;
import java.util.StringTokenizer;

/*_2589*/
public class Main {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int r, c, ans=0;
	static char[][] map;
	static boolean[][] visited;
//	static ArrayList<Node>[] arr;
	static Queue<Node> land_q = new LinkedList<Node>();
	static Queue<Node> move_q = new LinkedList<>();


	public static void bfs() {

		while (!move_q.isEmpty()) {
			Node node = move_q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];

				if (0 <= nx && nx < r && 0 <= ny && ny < c) {
					if (map[nx][ny] == 'L' && !visited[nx][ny]) {
						visited[nx][ny] = true;
						move_q.add(new Node(nx, ny, node.dist + 1));
						
						if(node.dist+1 > ans) {
							ans = node.dist+1;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];

		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
				
				if (map[i][j] == 'L') {
					land_q.add(new Node(i, j, 0));
				}
			}
		}


		int size = land_q.size();
		for (int i = 0; i < size; i++) { // 출발지 개수의 큐만큼 실행
			visited = new boolean[r][c];
			
			Node node = land_q.poll();
			visited[node.x][node.y] = true;
			move_q.add(new Node(node.x, node.y, 0));
			
			bfs();
			
		}
		System.out.println(ans);
	}
}
class Node {
	int x;
	int y;
	int dist;

	Node(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}
