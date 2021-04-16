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
			// ���ÿ��� �ϳ� ����, �� �� ���. �����̸� -1 ���
			if(str.equals("pop")) {
				size = stack.size();
				if(size == 0)
					sb.append(-1).append("\n");
				else {
					sb.append(stack.get(size - 1)).append("\n");
					stack.remove(size - 1);
				}
			}
			// ���ÿ� �ִ� ���� ���� ���
			if(str.equals("size")) {
				sb.append(stack.size()).append("\n");
			}
			// �� �����̸� 1, �ƴϸ� 0 ���
			if(str.equals("empty")) {
				size = stack.size();
				if(size == 0)
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
			}
			// ������ ���� ���� �ִ� ���� ���. �� ���� -1 ���
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
