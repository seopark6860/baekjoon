import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Alg_1260 {
	static ArrayList<Integer>[] map;
	static boolean[] visited;
	static int n, m, v;
	
	static void dfs(int start) {
		visited[start] = true;
		System.out.printf("%d ", start);
		
		for(int i : map[start]) {
			if(!visited[i]){
				dfs(i);
			}
		}
	}
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			start = q.poll();
			System.out.printf("%d ", start);
			
			for(int i : map[start]) {
				if(!visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		
		map = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			map[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<m; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			map[num1].add(num2);
			map[num2].add(num1);
		}
		
		// 여러개의 인접노드 중 정점 번호가 작은 것 먼저 방문하기 위한 정렬
		for(int i=1; i<map.length; i++) {
			Collections.sort(map[i]);
		}
		
		visited = new boolean[n+1];
		dfs(v);
		System.out.println();
		
		visited = new boolean[n+1];
		bfs(v);
		
		
	}
	
	
	/*
	static boolean[][] map;
	static boolean[] visited;
	static int n, m, v;
	
	static void dfs(int v) {
		if(visited[v] == true)
			return;
		visited[v] = true;
		System.out.printf("%d ", v);
		
		for(int i=1; i<=n; i++) {
			if(map[v][i] == true && visited[i] == false) {
				dfs(i);
			}
		}
		
	}
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visited[v] = true;
		System.out.printf("%d ", v);
		
		while(!q.isEmpty()){
			int x = q.poll();

			for(int j=1; j<=n; j++) {
				if(map[x][j] == true && visited[j] == false) {
					q.add(j);
					visited[j] = true;
					System.out.printf("%d ", j);
				}
			}
		}
		return;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		
		map = new boolean[n+1][n+1];
		
		for(int i=0; i<m; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			map[num1][num2] = true;
			map[num2][num1] = true;
		}
		
		visited = new boolean[n+1];
		dfs(v);
		System.out.println();
		
		visited = new boolean[n+1];
		bfs(v);
	}
	*/

}
