import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Alg_10773 {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int res = 0;
		
		Stack<Integer> stack = new Stack<>();
		while(k-- > 0) {
			int n = Integer.parseInt(br.readLine());
			if (n != 0) {
				stack.push(n);
				res += n;
			}
			else {
				res -= stack.peek();
				stack.pop();
			}
		}
		System.out.println(res);
	}
}
