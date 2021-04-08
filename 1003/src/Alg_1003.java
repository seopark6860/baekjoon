import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alg_1003 {
	static int[] zero;
	static int[] one;
	static int[] memo;
	
	public static void fibo(int n) {
		for(int i=2; i<=n; i++) {
			zero[i] = zero[i - 1] + zero[i - 2];
			one[i] = one[i - 1] + one[i - 2];
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			zero = new int[41];
			one = new int[41];
			
			zero[0] = 1;
			one[0] = 0;
			zero[1] = 0;
			one[1] = 1;
			if(n == 0) {
				System.out.println(zero[0] + " " + one[0]);
			}
			else if(n == 1) {
				System.out.println(zero[1] + " " + one[1]);
			}
			else {
				fibo(n);
				System.out.println(zero[n] + " " + one[n]);
			}
		}
	}

}
