import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Alg_2606 {
	static int com, line, res = 0;
	static int[][] arr;
	static boolean[] visited;
	
	public static void dfs(int x) {
		if(visited[x])
			return;
		visited[x] = true;
		
		for(int i=1; i<=com; i++) {
			if(arr[x][i] == 1 && !visited[i]) {
				res++;
				dfs(i);
			}
		}
	}
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		visited[x] = true;
		
		while(!q.isEmpty()) {
			int y = q.poll();
			
			for(int i=1; i<=com; i++) {
				if(arr[y][i] == 1 && !visited[i]) {
					res++;
					visited[i] = true;
					q.add(i);
				}
			}
			
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		com = Integer.parseInt(br.readLine());
		line = Integer.parseInt(br.readLine());
		
		arr = new int[com + 1][com + 1];
		for(int i=0; i<line; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			arr[u][v] = 1;
			arr[v][u] = 1;
		}
		visited = new boolean[com + 1];
	//	dfs(1);
		bfs(1);
		System.out.println(res);
	}
}