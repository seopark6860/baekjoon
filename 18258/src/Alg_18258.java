import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Alg_18258 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] q = new int[n];
		int front = 0;
		int back = 0;
		while(n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			if(str.equals("push")) {
				q[back++] = Integer.parseInt(st.nextToken());
			}
			if(str.equals("pop")) {
				if(back - front == 0)
					sb.append(-1).append("\n");
				else 
					sb.append(q[front++]).append("\n");
			}
			if(str.equals("size")) {
				sb.append(back - front).append("\n");
			}
			if(str.equals("empty")) {
				if(back - front == 0)
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
			}
			if(str.equals("front")) {
				if(back - front == 0)
					sb.append(-1).append("\n");
				else
					sb.append(q[front]).append("\n");
			}
			if(str.equals("back")) {
				if(back - front == 0)
					sb.append(-1).append("\n");
				else
					sb.append(q[back - 1]).append("\n");
			}
		}
		System.out.println(sb);
	}

}
