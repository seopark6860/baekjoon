import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Alg_13418 {
	static int n, m, c;
	static int[] parent;
	
	static double kruskal(PriorityQueue<Node> pq) {
		int cnt=0;	// 연결 경로 갯수
		int one_cnt = 0;	// 오르막길 갯수
		double ans = 0;		// 피로도
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			int a = find(node.x);
			int b = find(node.y);
			
			if(a==b) continue;
			
			union(a, b);
			cnt++;
			if(node.c == 0) {	// 오르막길 일때
				one_cnt++;
			}
			if(cnt == n) {
				break;
			}
		}
		ans = Math.pow(one_cnt, 2);
		return ans;
	}
	static int find(int x) {
		if(x == parent[x])
			return x;
		return parent[x] = find(parent[x]);
	}
	static void union(int x, int y) {
		int a = find(x);
		int b = find(y);
		
		if(a > b)
			parent[a] = b;
		else
			parent[b] = a;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		PriorityQueue<Node> min_pq = new PriorityQueue<>();
		for(int i=0; i<=m ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			min_pq.add(new Node(u, v, c));
		}
		
		PriorityQueue<Node> max_pq = new PriorityQueue<>(min_pq.size(), Collections.reverseOrder());
		max_pq.addAll(min_pq);
		
		parent = new int[n+1];
		for(int i=0; i<=n; i++) {
			parent[i] = i;
		}
		double max = kruskal(min_pq);
		
		parent = new int[n+1];
		for(int i=0; i<=n; i++) {
			parent[i] = i;
		}
		double min = kruskal(max_pq);
		
		System.out.println((int)(max-min));
	}


}
class Node implements Comparable<Node> {
	int x, y, c;
	Node(int x, int y, int c){
		this.x = x;
		this.y = y;
		this.c = c;
	}
	public int compareTo(Node t) {
		return this.c > t.c ? 1 : -1;
	}
}
