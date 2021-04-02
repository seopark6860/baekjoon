import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alg_2577 {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		
		int sum = a * b * c;
		String str = String.valueOf(sum);
		
		int[] arr = new int[10];
		int len = str.length();
		int idx = 0;
		while(len-- > 0) {
			arr[str.charAt(idx) - '0']++;
			idx++;
		}
		for(int i=0; i<10; i++) {
			System.out.println(arr[i]);
		}
	}

}
