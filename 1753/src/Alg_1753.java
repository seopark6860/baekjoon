import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Alg_1753 {
	static int INF = 1000000000;
	static int v, e;
	static ArrayList<Node>[] arr;
	static int[] dist;

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(dist[now.v] < now.w){
				continue;
			}
			for(Node next : arr[now.v]) {
				if(dist[next.v] > now.w + next.w) {
					dist[next.v] = now.w + next.w;
					pq.add(new Node(next.v, dist[next.v]));
				}
			}
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[v+1];
		for(int i=1; i<=v; i++) {
			arr[i] = new ArrayList<>();
		}
		
		int k = Integer.parseInt(br.readLine());
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			arr[u].add(new Node(v, w));
		}
		
		
		dist = new int[v+1];
		Arrays.fill(dist, INF);
		dijkstra(k);
		
		for(int i=1; i<=v; i++) {
			if(dist[i] >= INF) {
				System.out.println("INF");
			}else
				System.out.println(dist[i]);
		}
		
	}

}
class Node implements Comparable<Node>{
	int v, w;
	Node(int v, int w){
		this.v = v;
		this.w = w;
	}
	public int compareTo(Node t) {
		return this.w > t.w ? 1 : -1;
	}
}