import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Alg_2610 {
	static int[] dx= {0, 1, 0, -1};
	static int[] dy= {1, 0, -1, 0};
	static int INF = 1000000000;
	static int n, m, group=0;
	static int[][] arr;
	static boolean[] visited;
	static int[] d;
	static ArrayList<Integer> list = new ArrayList<>();	// 위원회 대표 저장할 리스트
	
	public static void printMap() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	
	public static int bfs(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		visited[x] = true;
//		group++;
	
		int boss = INF;
		while(!q.isEmpty()) {
			int num = q.poll();
			
			for(int i=1; i<=n; i++) {
				if(i == num) continue;
				if(arr[num][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
				if(arr[num][i]==1 && d[num] > d[i]) {
					boss = i;
				}
			}
			if(boss == INF) {
				return num;
			}
		}
		return boss;		
	}
	
	public static void floyd() {
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
//					if(k==i || k==j || )
					if(arr[i][j] > arr[i][k]+arr[k][j]) {
						arr[i][j] = arr[i][k]+arr[k][j];
					}
				}
			}
		}
	}
	
	public static void solve() {
		int max = INF;
		// 각 참석자의 의사전달 시간
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j || arr[i][j] == INF)
					continue;
				d[i] += arr[i][j];
				max = Math.min(max, d[i]);
			}
			
		}
		
		// 위원회의 개수 및 대표
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				group++;
				list.add(bfs(i));
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		d = new int[n+1];
		visited = new boolean[n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				arr[i][j] = INF;
			}
		}
		// 입력
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		// 플로이드 알고리즘
		floyd();
		// 위원회 개수 및 대표 
		solve();
		for(int i=1; i<=n; i++) {
			System.out.printf("%d ", d[i]);
		}
		
		System.out.println(list.size());
		
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
