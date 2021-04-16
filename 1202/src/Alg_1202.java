import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Alg_1202 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
	
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		ArrayList<Node> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.add(new Node(m, v));
		}
		int[] bag = new int[k];
		for(int i=0; i<k; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		Collections.sort(list);
		Arrays.sort(bag);
		
		int j = 0;
		long res = 0;
		for(int i=0; i<k; i++) {
			while(j < n && list.get(j).m <= bag[i]) {
				pq.add(list.get(j).v);
				j++;
			}
			if(!pq.isEmpty()) {
				res += pq.peek();
				pq.poll();
			}
		}
		System.out.println(res);
	}
}
class Node implements Comparable<Node> {
	int m;
	int v;
	Node(int m, int v) {
		this.m = m;
		this.v = v;
	}
	public int compareTo(Node c) {
		return this.m - c.m;
	}
}
