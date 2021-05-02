import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_2630 {
	static int[][] arr;
	static int white = 0, blue = 0;
	
	public static boolean check(int n, int row, int col) {
		int ch = arr[col][row];
		for(int i=col; i<n + col; i++) {
			for(int j=row; j<n + row; j++) {
				if(ch != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	public static void solve(int n, int row, int col) {
		if(check(n, row, col)) {	// 모두 같은 색으로 이뤄져 있는지 체크하는 함수
			if(arr[col][row] == 1)
				blue++;
			else 
				white++;
		}
		else {
			solve(n / 2, row, col);				
			solve(n / 2, row, col + n/2);		
			solve(n / 2, row + n/2, col);		
			solve(n / 2, row + n/2, col + n/2);	
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
	
		arr = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/*
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		*/
		solve(n, 0, 0);
		System.out.println(white);
		System.out.println(blue);
	}

}
