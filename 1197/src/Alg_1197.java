import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Alg_1197 {
	static int v, e;
	static int[] parent;
	static ArrayList<Node>[] arr;
	static PriorityQueue<Node> pq = new PriorityQueue<>();

	public static int kruskal() {
		int ans = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			int a = find(node.x);
			int b = find(node.y);
			
			if(a==b) continue;
			
			
			union(a, b);
			ans += node.cost;
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
		
		if(a > b) {
			parent[a] = b;
		}
		else
			parent[b] = a;
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		v = sc.nextInt();
		e = sc.nextInt();

		arr = new ArrayList[v + 1];
		for (int i = 1; i <= v; i++) {
			arr[i] = new ArrayList<>();
		}
		
		parent = new int[v+1];
		for(int i=1; i<=v; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < e; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int c = sc.nextInt();

			arr[x].add(new Node(y, c));
			arr[y].add(new Node(x, c));
			
			pq.add(new Node(x, y, c));
		}
		
		System.out.println(kruskal());
	}
}

class Node implements Comparable<Node> {
	int x;
	int y;
	int cost;

	Node(int x, int cost) {
		this.x = x;
		this.cost = cost;
	}
	Node(int x, int y, int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}

	public int compareTo(Node t) {
		return this.cost > t.cost ? 1 : -1;
	}
}
