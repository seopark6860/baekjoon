import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alg_2231 {

	public static int Sum(int n) {
		int sum = 0;
		while(n > 0) {
			sum += n%10;
			n /= 10;
		}
		return sum;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=n; i++) {
			int res = Sum(i);
			if(res + i == n) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}
}
