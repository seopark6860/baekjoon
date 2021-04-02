import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Alg_1922 {
	static int n, m;
	static int[] parent;
	static ArrayList<Com> arr;
	static PriorityQueue<Com> pq;
	
	public static int kruskal() {
		int ans = 0;
		
		while(!pq.isEmpty()) {
			Com com = pq.poll();
			
			int a = find(com.u);
			int b = find(com.v);
			if(a==b) {
				continue;
			}
			
			union(a, b);
			ans += com.c;
		}
		return ans;
	}
	private static int find(int x) {
		if(x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	private static void union(int x, int y) {
		int a = find(x);
		int b = find(y);
		
		if(a == b) return;
		if(a > b)
			parent[a] = b;
		else 
			parent[b] = a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		pq = new PriorityQueue<>();
		parent = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int c = sc.nextInt();
			
			pq.add(new Com(u, v, c));
		}
		
		System.out.println(kruskal());
	}

}
class Com implements Comparable<Com>{
	int u;
	int v;
	int c;
	Com(int u, int v, int c){
		this.u = u;
		this.v = v;
		this.c = c;
	}
	public int compareTo(Com t) {
		return this.c > t.c	? 1 : -1;
	}
}