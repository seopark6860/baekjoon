import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Alg_7576 {
	static int[] dx= {0, 1, 0, -1};
	static int[] dy= {1, 0, -1, 0};
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Node> start;
	static int n, m;

	public static void bfs() {
		Queue<Node> q = new LinkedList<Node>();
		
		for(int i=0; i<start.size(); i++) {
			Node node = start.get(i);
			q.add(node);
			visited[node.x][node.y] = true;
		}
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx>=0 && ny>=0 && nx<n && ny<m) {
					if(map[nx][ny]!=-1 && !visited[nx][ny]) {
						q.add(new Node(nx, ny));
						visited[nx][ny] = true;
						map[nx][ny] = map[node.x][node.y]+1;
					}
				}
			}
		}
		int max = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==0) {		// 익지 않은 토마토 있을 시 -1 출력
					System.out.println(-1);
					return;
				}
				max = Math.max(max, map[i][j]);
			}
		}
		System.out.println(max-1); 		// 최대일수 출력
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt();
		n = sc.nextInt();
		map = new int[n][m];
		visited = new boolean[n][m];
		start = new ArrayList<>();
		
		sc.nextLine();
		for(int i=0; i<n; i++) {
			String str = sc.nextLine();
			String[] arr = str.split(" ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(arr[j]);
			}
		}
		
		// 익은 토마토가 있는 곳(시작 노드) start배열에 넣기
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 1) {
					start.add(new Node(i, j));
				}
			}
		}
		bfs();
		/* 농장 전체 보여줌
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		*/
		
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