import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alg_10870 {
	
	public static int solve(int n) {
		if(n <= 1) {
			return n;
		} 
		return solve(n - 1) + solve(n - 2);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(solve(n));
	}
}