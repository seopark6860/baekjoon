import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_1629 {
	
	public static long solve(long a, long b, long c) {
		// 지수가 1일 경우 a^1이므로 a 리턴
		if(b == 1) {
			return a % c;
		}
		else {
			long tmp = solve(a, b / 2, c);
			if(b % 2 == 0) {
				return (tmp * tmp) % c;
			}
			else {
				return (((tmp * tmp) % c) * a) % c;
			}
		}
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
