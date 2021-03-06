import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_1018 {
	static char[][] whiteChess = new char[8][8];
	static char[][] blackChess = new char[8][8];
	static int cnt = Integer.MAX_VALUE;
	
	public static void makeChess() {
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(i%2 == 0 && j%2 == 0) {
					whiteChess[i][j] = 'W';
					blackChess[i][j] = 'B';
				}
				if(i%2 == 0 && j%2 == 1) {
					whiteChess[i][j] = 'B';
					blackChess[i][j] = 'W';
				}
				if(i%2 == 1 && j%2 == 0) {
					whiteChess[i][j] = 'B';
					blackChess[i][j] = 'W';
				}
				if(i%2 == 1 && j%2 == 1) {
					whiteChess[i][j] = 'W';
					blackChess[i][j] = 'B';
				}
			}
		}
	}
	public static void solve(char[][] arr, int x, int y) {
		int tmp = 0;
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(arr[x + i][y + j] != whiteChess[i][j]) {
					tmp++;
				}
			}
		}
		cnt = Math.min(cnt, tmp);
		tmp = 0;
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(arr[x + i][y + j] != blackChess[i][j])
					tmp++;
			}
		}
		cnt = Math.min(cnt, tmp);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[n][m];
		for(int i=0; i<n; i++) {
			String str = br.readLine();		
			for(int j=0; j<m; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		makeChess();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(i + 8 <= n && j + 8 <= m) {
					solve(arr, i, j);
				}
			}
		}
		System.out.println(cnt);
	}

}
