import java.util.Scanner;

/*9663*/
public class Main {
	static int n;
	static int cnt=0;
	static int[] map;
	
	public static void dfs(int x) {
		// 행 다 채우면 카운트 1 증가시키고 리턴
		if (x == n) {
			cnt++;
			return;
		}
		
		for(int i=0; i<n; i++) {
			map[x] = i;
			if(check(x)) {
				dfs(x+1);
			}
		}
	}

	// 퀸을 놓을 수 있는 자리인지 체크하는 함수
	public static boolean check(int col) {	// 행 열
		for(int i=0; i<col; i++) {
			// 해당 열의 행과 i열의 행이 일치할 경우 (같은 행에 존재할 경우)
			if(map[col] == map[i]) {
				return false;
			}
			// 대각선상에 놓여있는 경우 (열의 차와 행의 차가 같을 경우 대각선에 놓인 경우
			if(Math.abs(col-i) == Math.abs(map[col]-map[i])) {
				return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		map = new int[n];
		
		/* int map[행인덱스(row)] = 열인덱스(col)
		 * 	
		 */
		dfs(0);
		System.out.println(cnt);
	}
}