import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Alg_10828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> stack = new ArrayList<>();
		int size = 0;		
		while(n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("push")) {
				int x = Integer.parseInt(st.nextToken());
				stack.add(x);
			}
			// 스택에서 하나 빼고, 그 수 출력. 빈스택이면 -1 출력
			if(str.equals("pop")) {
				size = stack.size();
				if(size == 0)
					sb.append(-1).append("\n");
				else {
					sb.append(stack.get(size - 1)).append("\n");
					stack.remove(size - 1);
				}
			}
			// 스택에 있는 정수 개수 출력
			if(str.equals("size")) {
				sb.append(stack.size()).append("\n");
			}
			// 빈 스택이면 1, 아니면 0 출력
			if(str.equals("empty")) {
				size = stack.size();
				if(size == 0)
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
			}
			// 스택의 가장 위에 있는 정수 출력. 빈 스택 -1 출력
			if(str.equals("top")) {
				size = stack.size();
				if(size == 0) 
					sb.append(-1).append("\n");
				else
					sb.append(stack.get(size - 1)).append("\n");
			}
		}
		System.out.println(sb);
	}
}
