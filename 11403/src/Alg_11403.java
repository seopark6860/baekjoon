import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_11403 {
	static int INF = 1000000000;
	static int n;
	static int[][] arr;


	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
			}
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (arr[i][k] == 1 && arr[k][j] == 1)
						arr[i][j] = 1;
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
