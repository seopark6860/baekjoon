import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer>[] a;
	static Queue<Integer> q;
	static int[] ind;
	
	public static void topologicalSort(int n) {
		while(!q.isEmpty()) {
			System.out.print(q.peek() + " ");
			int x = q.poll();
			
			for(int i=0; i<a[x].size(); i++) {
				int y = a[x].get(i);
				ind[y]--;
				if(ind[y] == 0) {
					q.add(y);
				}
			}
		}
//		for(int i=0; i<n; i++) {
//			int x = q.remove();
//			System.out.print(x + " ");
//			for(int y : a[x]) {
//				ind[y]--;
//				if(ind[y] == 0) {
//					q.add(y);
//				}
//			}
//		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();		// 키 비교한 횟수
		ind = new int[n+1];		
		a = (ArrayList<Integer>[])new ArrayList[n+1];
		q = new LinkedList<Integer>();
		
		for(int i=1; i<=n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<=m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v);
			ind[v]++;
		}
		for(int i=1; i<=n; i++) {
			if(ind[i] == 0) {
				q.add(i);
			}
		}
		topologicalSort(n);
	}
}
