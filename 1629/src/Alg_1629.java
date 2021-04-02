import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_1629 {
	
	public static long solve(long a, long b, long c) {
		if(b == 0) return 1;
		if(b % 2 == 1) {
			long res = solve(a, b/2, c) % c;
			return (res * res) % c;
		} else {
			long res = solve(a, b/2, c) % c;
			return 
		}
		return res;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		long c = Integer.parseInt(st.nextToken());
		
		
		System.out.println(solve(a, b, c));
	}

}
