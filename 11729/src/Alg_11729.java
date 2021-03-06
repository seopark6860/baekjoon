import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alg_11729 {
	static int cnt = 0;
	public static StringBuilder sb = new StringBuilder();
	
	public static void hanoi(int n, int start, int to, int via) {
		if(n == 1) {
			cnt++;
			sb.append(start + " " + to + "\n");
//			System.out.println(start + " " + to);
			return;
		}
		hanoi(n-1, start, via, to);
		sb.append(start + " " + to + "\n");
		cnt++;
//		System.out.println(start + " " + to);
		hanoi(n-1, via, to, start);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		hanoi(n, 1, 3, 2);
		System.out.println(cnt);
		System.out.println(sb);
	}

}
