import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Alg_1260 {
	static int n, m, v;
	static int[][] arr;
	static boolean[] visited;
	
	public static void dfs(int x) {
		if(visited[x])
			return;
		visited[x] = true;
		System.out.print(x + " ");
		for(int i=1; i<=n; i++) {
			if(arr[x][i] == 1 && !visited[i])
				dfs(i);
		}
	}
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		visited[x] = true;
		System.out.print(x + " ");
		
		while(!q.isEmpty()) {
			int y = q.poll();
			for(int i=1; i<=n; i++) {
				if(arr[y][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
					System.out.print(i + " ");
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		arr = new int[n + 1][n + 1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[u][v] = 1;
			arr[v][u] = 1;
		}
		visited = new boolean[n + 1];
		dfs(v);
		System.out.println();
		visited = new boolean[n + 1];		
		bfs(v);
	}
}
