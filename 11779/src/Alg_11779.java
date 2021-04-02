import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Alg_11779 {
	static int INF = 1000000000;
	static int n, m;
	static ArrayList<Node>[] arr;
	static int[] path;	// 경로저장
	static int[] dist;
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(start, 0));		// 시작점 pq에 저장
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();		// start부터 탐색
			
			if(dist[now.v] < now.c) 
				continue;
			
			for(Node next : arr[now.v]) {
				if(dist[next.v] > now.c + next.c) {
					dist[next.v] = now.c + next.c;
					pq.add(new Node(next.v, dist[next.v]));
					path[next.v] = now.v;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = new ArrayList<>();
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
	
		dist = new int[n+1];
		for(int i=1; i<=n; i++) {
			dist[i] = INF;
		}
	
		path = new int[n+1];
		dijkstra(start);
		
		ArrayList<Integer> ans = new ArrayList<>();
		// 경로 구하기
		int n = end;
		while(n != 0) {
			ans.add(n);
			n = path[n];
//			System.out.println(n);
		}
		
		System.out.println(dist[end]);
		System.out.println(ans.size());
		for(int i=ans.size()-1; 0<=i; i--) {
			System.out.printf("%d ", ans.get(i));
		}
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