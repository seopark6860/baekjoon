import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_15652 {
	static int n, m;
	static int[] arr;
	static boolean[] v;
	
	public static void dfs(int depth, int num) {
		if(depth == m) {
			for(int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for(int i=1; i<=n; i++) {
			arr[depth] = num + i;
			dfs(depth + 1, num);
			num -= 1;
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
		dfs(0, 0);
	}

}
