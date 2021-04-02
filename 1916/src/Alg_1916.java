import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Alg_1916 {
	static int INF = 1000000000;
	static ArrayList<Node>[] arr;
	static int[] dist;
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(dist[now.v] < now.c) {
				continue;
			}
			
			for(Node next : arr[now.v]) {
				if(dist[next.v] > now.c + next.c) {
					dist[next.v] = now.c + next.c;
					pq.add(new Node(next.v, dist[next.v]));
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		arr = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = new ArrayList<>();
		}
		
		dist = new int[n+1];
		for(int i=1; i<=n; i++) {
			dist[i] = INF;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[u].add(new Node(v, c));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		System.out.println(dist[end]);
	}

}
class Node implements Comparable<Node> {
	int v, c;
	Node(int v, int c){
		this.v = v;
		this.c = c;
	}
	public int compareTo(Node t) {
		return this.c > t.c ? 1 : -1;
	}
}