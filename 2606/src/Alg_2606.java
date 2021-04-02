import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Alg_2606 {
//	static int[][] arr;
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	static int com, c, answer;
	
	/*
	static void dfs(int x) {
		if(visited[x]) {
			return;
		}
		visited[x] = true;
		for(int i=1; i<arr.length; i++) {
			if(arr[x][i] == 1 && visited[i] == false) {
				answer++;
				dfs(i);
				
			}
		}
		
	}
	*/
	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(x);
		visited[x] = true;
		
		while(!q.isEmpty()) {
			int y = q.poll();

			for(int i : arr[y]) {
				if(!visited[i]) {
					q.add(i);
					answer++;
					visited[i] = true;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		com = sc.nextInt();
		c = sc.nextInt();
		
		arr = new ArrayList[com+1];
//		arr = new int[com+1][com+1];
		visited = new boolean[com+1];
		
		for(int i=1; i<=com; i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i=0; i<c; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			arr[u].add(v);
			arr[v].add(u);
//			arr[u][v] = 1;
//			arr[v][u] = 1;
		}
	
		answer = 0;
//		dfs(1);	
		bfs(1);
		System.out.println(answer);
	}

}
