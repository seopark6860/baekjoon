import java.util.Scanner;

public class Alg_2606_1 {
	static int[][] map;
	static boolean[] visited;
	static int cnt=0;
	
	public static void dfs(int x) {
		if(visited[x]) {
			return;
		}
		visited[x] = true;
		
		for(int i=0 ; i<map.length; i++) {
			if(map[x][i] == 1 && visited[i] == false) {
				cnt++;
				dfs(i);
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int com = sc.nextInt();
		int edge = sc.nextInt();
		
		map = new int[com+1][com+1];
		
		for(int i=0; i<edge; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			map[u][v] = 1;
			map[v][u] = 1;
		}
		
		visited = new boolean[com+1];
		dfs(1);
		
		System.out.println(cnt);
	}

}
