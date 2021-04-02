import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_2458 {
	static int INF = 1000000000;
	static int n, m;
	static int[][] d;
	static int[] ans;

	public static void printMap() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void solve() {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (d[i][k] == 1 && d[k][j] == 1) {
						d[i][j] = 1;
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			int tall = 0;
			int shor = 0;
			for (int j = 1; j <= n; j++) {
				if (d[i][j] == 1) {
					tall++;
				}
				if (d[j][i] == 1) {
					shor++;
				}
			}
			ans[i] = tall + shor;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		d = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			d[a][b] = 1;
		}
		ans = new int[n + 1];
		solve();

		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if (ans[i] == n - 1) {
				answer++;
			}
		}
		System.out.println(answer);
	}

}
