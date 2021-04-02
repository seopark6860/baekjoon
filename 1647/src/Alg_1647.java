import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Alg_1647 {
	static int n, m;
	static int[] parent;
	static PriorityQueue<City> pq = new PriorityQueue<>();
	
	public static int kruskal() {
		int ans = 0;
		int cnt = 0;
		
		while(cnt < n-2) {
			City city = pq.poll();
			
			
			int a = find(city.u);
			int b = find(city.v);
			
			if(a == b) continue;
			cnt++;
//			if(cnt == n-1) {
//				ans -= city.cost;
//				return ans;
//				break;
//			}
			union(a, b);
			ans += city.cost;
			
			
		}
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
//		Scanner sc = new Scanner(System.in);
		
//		n = sc.nextInt();
//		m = sc.nextInt();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		
		parent = new int[n+1];
		for(int i=1; i<=n; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
//			int u = sc.nextInt();
//			int v = sc.nextInt();
//			int c = sc.nextInt();
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			pq.add(new City(u, v, c));
		}
		
		System.out.println(kruskal());
	}

}
class City implements Comparable<City>{
	int u, v, cost;
	City(int u, int v, int cost){
		this.u = u;
		this.v = v;
		this.cost = cost;
	}
	public int compareTo(City t) {
		return this.cost > t.cost ? 1 : -1;
	}
}