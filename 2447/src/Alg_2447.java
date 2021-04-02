import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Alg_2447 {
	static char[][] arr;
	
	public static void solve(int x, int y, int n) {
		if(n == 1) {		// 공백 칸일 경우
			arr[x][y] = '*';
			return;
		}
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(i == 1 && j == 1) continue;
				solve(x + i*(n/3), y + j*(n/3), n/3);
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		arr = new char[n][n];
		for(int i=0; i<n; i++) {
			Arrays.fill(arr[i], ' ');
		}
		solve(0, 0, n);
	
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
