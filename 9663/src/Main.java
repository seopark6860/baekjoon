import java.util.Scanner;

/*9663*/
public class Main {
	static int n;
	static int cnt=0;
	static int[] map;
	
	public static void dfs(int x) {
		// �� �� ä��� ī��Ʈ 1 ������Ű�� ����
		if (x == n) {
			cnt++;
			return;
		}
		
		for(int i=0; i<n; i++) {
			map[x] = i;
			if(check(x)) {
				dfs(x+1);
			}
		}
	}

	// ���� ���� �� �ִ� �ڸ����� üũ�ϴ� �Լ�
	public static boolean check(int col) {	// �� ��
		for(int i=0; i<col; i++) {
			// �ش� ���� ��� i���� ���� ��ġ�� ��� (���� �࿡ ������ ���)
			if(map[col] == map[i]) {
				return false;
			}
			// �밢���� �����ִ� ��� (���� ���� ���� ���� ���� ��� �밢���� ���� ���
			if(Math.abs(col-i) == Math.abs(map[col]-map[i])) {
				return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		map = new int[n];
		
		/* int map[���ε���(row)] = ���ε���(col)
		 * 	
		 */
		dfs(0);
		System.out.println(cnt);
	}
}