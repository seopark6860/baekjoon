import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_10807 {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (n == v)
				cnt++;
		}
		System.out.println(cnt);
	}
}
