import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Alg_1504 {
	static int INF = 200000000;
	static int n, e;
	static int v1, v2;
	static boolean[] visited;
	static ArrayList<Node>[] arr;
	
	public static int dijkstra(int start, int end) {
		 int[] dist = new int[n+1];
		 Arrays.fill(dist, INF);
		 
		 PriorityQueue<Node> pq = new PriorityQueue<>();
		
		 pq.add(new Node(start, 0));	// 1번 정점부터 시작
		 dist[start] = 0;
		 
		 while(!pq.isEmpty()) {
			 Node now = pq.poll();
			 
			 if(dist[now.v] < now.c)
				 continue;
				 
			 for(Node next : arr[now.v]) {
				 if(dist[next.v] > now.c + next.c) {
					 dist[next.v] = now.c + next.c;
					 pq.add(new Node(next.v, dist[next.v]));
				 }
			 }
		 }
		 return dist[end];
		 
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[a].add(new Node(b, c));
			arr[b].add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		// 1 - v1 - v1 - n
		int x1 = dijkstra(1, v1);	
		int x2 = dijkstra(v1, v2);
		int x3 = dijkstra(v2, n);
		int ans1 = x1+x2+x3;
		
		// 1 - v2 - v1 - n
		int y1 = dijkstra(1, v2);
		int y2 = dijkstra(v2, v1);
		int y3 = dijkstra(v1, n);
		int ans2 = y1+y2+y3;
		
		int ans = Math.min(ans1, ans2);
		if(ans >= INF) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
		
	}
}
class Node implements Comparable<Node>{
	int v, c;
	Node(int v, int c){
		this.v = v;
		this.c = c;
	}
	public int compareTo(Node t) {
		return this.c > t.c ? 1 : -1;
	}
}