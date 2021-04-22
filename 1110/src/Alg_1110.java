import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alg_1110 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		int new_num = n;
		while(true) {
			int x = new_num /10;		// 십의 자리
			int y = new_num % 10;		// 일의 자리
			int z = x + y;

			cnt++;
			new_num = 10 * y + (z % 10);
			if(new_num == n) {
				System.out.println(cnt);
				break;
			}
		}
	}

}
