import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Alg_1697 {
	static int res;
	static boolean[] v;
	static Queue<Node> q = new LinkedList<Node>();
	
	public static void bfs(int n, int k) {
		q.add(new Node(n, 0));
		v[n] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
//			System.out.println("q : " + node.x + " cnt : " + node.cnt);
			int x1 = node.x + 1;
			int x2 = node.x - 1;
			int x3 = node.x * 2;
			if(0 <= x1 && x1 <= 100000 && !v[x1]) {
				q.add(new Node(x1, node.cnt + 1));
				v[x1] = true;
			}
			if(0 <= x2 && x2 <= 100000 && !v[x2]) {
				q.add(new Node(x2, node.cnt + 1));
				v[x2] = true;
			}
			if(0 <= x3 && x3 <= 100000 && !v[x3]) {
				q.add(new Node(x3, node.cnt + 1));
				v[x3] = true;
			}
			
			if(node.x == k) {
				res = node.cnt;
				return;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		v = new boolean[100001];	
		res = Integer.MAX_VALUE;
		
		bfs(n, k);
		System.out.println(res);
		
	}

}
class Node {
	int x;
	int cnt;
	Node(int x, int cnt){
		this.x = x;
		this.cnt = cnt;
	}
}
