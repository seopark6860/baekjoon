import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alg_10989 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] count = new int[10001];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i : arr) {
			count[i]++;
		}
		for(int i=0; i<10001; i++) {
			while(count[i] > 0) {
				sb.append(i).append('\n');
				count[i]--;
			}
		}
		System.out.println(sb);
	}

}
