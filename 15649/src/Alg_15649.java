import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_15649 {
	static int n, m;
	static int[] arr;
	static boolean[] v;
	
	public static void dfs(int depth) {
		if(depth == m) {
			for(int i=0; i<m; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
			return;
		}
		for(int i=0; i<n; i++) {
			// 해당 노드(값)을 방문하지 않았다면
			if(!v[i]) {
				v[i] = true;	// 해당 노드를 방문상태로 변경
				arr[depth] = i+1;	// 해당 깊이를 index로 해 i + 1값 저장
				dfs(depth + 1);		// 다음 자식노드 방문을 위해 depth 1증가시키면서 재귀호출
				v[i] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		v = new boolean[n];
		dfs(0);
	}

}
