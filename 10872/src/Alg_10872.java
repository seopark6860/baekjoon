import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alg_10872 {
	static int n;
	static int res = 1;
	
	public static void solve(int depth) {
		if(depth == n-1) {
			return;
		}
		res *= (n - depth);
		solve(depth + 1);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		if(n == 0) {
			System.out.println(res);
			return;
		}
		solve(0);
		System.out.println(res);
	}

}
