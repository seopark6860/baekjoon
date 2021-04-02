import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Alg_3055 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int r, c, ans = 0;
	static String[][] map;
	static Queue<Node> sq = new LinkedList<>();;
	static Queue<Node> wq = new LinkedList<>();;
	static boolean[][] sVisited;

	public static int bfs() {

		while (!sq.isEmpty()) {
			// ¹°
			int water = wq.size();
			for (int i = 0; i < water; i++) {
				Node wNode = wq.poll();
				for (int j = 0; j < 4; j++) {
					int wx = wNode.x + dx[j];
					int wy = wNode.y + dy[j];

					if (0 <= wx && wx < r && 0 <= wy && wy < c) {
						if (map[wx][wy].equals(".") || map[wx][wy].equals("S")) {
							map[wx][wy] = "*";
							wq.add(new Node(wx, wy, 0));
						}
					}
				}
			}
			// °í½¿µµÄ¡
			int hog = sq.size();
			for (int i = 0; i < hog; i++) {
				Node sNode = sq.poll();
//				sVisited[sNode.x][sNode.y] = true;
				
				for (int j = 0; j < 4; j++) {
					int sx = sNode.x + dx[j];
					int sy = sNode.y + dy[j];

					if (0 <= sx && sx < r && 0 <= sy && sy < c) {
						if (map[sx][sy].equals(".") && !sVisited[sx][sy]) {
							sq.add(new Node(sx, sy, sNode.time + 1));
							sVisited[sx][sy] = true;
						}
						if (map[sx][sy].equals("D")) {
							return sNode.time + 1;
						}
					}
				}
			}

		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		r = sc.nextInt();
		c = sc.nextInt();
		map = new String[r][c];
		sVisited = new boolean[r][c];
		
		for (int i = 0; i < r; i++) {
			String str = sc.next();
			for (int j = 0; j < c; j++) {
				map[i][j] = String.valueOf(str.charAt(j));
				if (map[i][j].equals("S")) {
					sq.add(new Node(i, j, 0));
					sVisited[i][j] = true;
				}
				if (map[i][j].equals("*")) {
					wq.add(new Node(i, j, 0));
				}
			}
		}
		int answer = bfs();
		System.out.println((answer == 0) ? "KAKTUS" : answer);
	}
}

class Node {
	int x;
	int y;
	int time;

	Node(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}
}
