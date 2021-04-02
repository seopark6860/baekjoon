import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Alg_13549 {
	static int INF = 1000000000;
	static int n, k;
	static int[] dist;

	public static void dijkstra(int n) {
//		PriorityQueue<Node> pq = new PriorityQueue<>();
		Queue<Node> q = new LinkedList<Node>();

//		pq.add(new Node(n, 0));
		q.add(new Node(n, 0));
		dist[n] = 0;

		while (!q.isEmpty()) {
			Node now = q.poll();

			if (dist[k] != INF)
				return;
			if (2*now.x <= 100000 && dist[2 * now.x] > now.time) {
				dist[2 * now.x] = now.time;
				q.add(new Node(2 * now.x, now.time));
			}
			if (0<= now.x-1 && dist[now.x - 1] > now.time) {
				dist[now.x - 1] = now.time + 1;
				q.add(new Node(now.x - 1, now.time + 1));
			}
			if (now.x+1 <= 100000 && dist[now.x + 1] > now.time) {
				dist[now.x + 1] = now.time + 1;
				q.add(new Node(now.x + 1, now.time + 1));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		dist = new int[100001];
		Arrays.fill(dist, INF);

		dijkstra(n);

		System.out.println(dist[k]);
	}

}

class Node implements Comparable<Node> {
	int x, time;

	Node(int x, int time) {
		this.x = x;
		this.time = time;
	}

	public int compareTo(Node t) {
		return this.time > t.time ? 1 : -1;
	}
}
