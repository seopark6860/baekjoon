import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_2609 {

	public static void solve(int n1, int n2) {
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		
		int min = Math.min(n1,  n2);
		int gcd = 1;
		int lcm = 1;
		
		solve();
		
		for(int i=2; i<=min; i++) {
			if(n1%i == 0 && n2%i == 0) {
				n1 /= i;
				n2 /= i;
				if(gcd < i)
					gcd = i;
				lcm *= i;
			}
		}
		lcm *= (n1%gcd) * (n2%gcd);
		System.out.println(gcd);
		System.out.println(lcm);
	}

}
