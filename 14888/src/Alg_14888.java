import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_14888 {
	static int n;
	static int[] num;
	static int[] op = new int[4];
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	
	public static void solve(int sum, int cnt) {
		if(cnt == n) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		for(int i=0; i<4; i++) {
			if(op[i] != 0) {
				op[i]--;
				
				if(i == 0) {
					solve(sum + num[cnt], cnt + 1);
				} else if(i == 1) {
					solve(sum - num[cnt], cnt + 1);
				} else if(i == 2) {
					solve(sum * num[cnt], cnt + 1);
				} else if(i == 3) {
					solve(sum / num[cnt], cnt + 1);
				}
				op[i]++;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		solve(num[0], 1);
		System.out.println(max);
		System.out.println(min);
	}

}
