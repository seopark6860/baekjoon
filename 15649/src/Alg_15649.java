import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_15649 {
	static int n, m;
	static int[] arr;
	static boolean[] v;
	
	public static void dfs(int depth) {
		if(depth == m) {
			for(int i=0; i<m; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
			return;
		}
		for(int i=0; i<n; i++) {
			// �ش� ���(��)�� �湮���� �ʾҴٸ�
			if(!v[i]) {
				v[i] = true;	// �ش� ��带 �湮���·� ����
				arr[depth] = i+1;	// �ش� ���̸� index�� �� i + 1�� ����
				dfs(depth + 1);		// ���� �ڽĳ�� �湮�� ���� depth 1������Ű�鼭 ���ȣ��
				v[i] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		v = new boolean[n];
		dfs(0);
	}

}