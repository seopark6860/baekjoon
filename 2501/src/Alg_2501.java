import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_2501 {
	static int n, k, i, cnt;
	
	public static void solve(int n, int k) {
		i = 1;
		cnt = 0;
		
		while(i <= n) {
			if(cnt == k)
				return;
			if(n % i == 0) {
				i++;
				cnt++;
				continue;
			}
			i++;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		
		solve(n, k);
		
		if(cnt < k) {
			System.out.println(0);
		}
		else
			System.out.println(i-1);
	}

}
