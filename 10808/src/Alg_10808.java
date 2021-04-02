import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alg_10808 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();

		int[] arr = new int[26];
		for(int i=0; i<str.length(); i++) {
			int idx = str.charAt(i) - 'a';
			arr[idx]++;
		}
		for(int i=0; i<26; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
