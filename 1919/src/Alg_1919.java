import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alg_1919 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		int[] arr = new int[26];
		
		int len = s1.length() + s2.length();
		int cnt = 0;
		for(int i=0; i<s1.length(); i++) {
			arr[s1.charAt(i) - 'a']++;
		}
		for(int j=0; j<s2.length(); j++) {
			if(arr[s2.charAt(j) - 'a'] > 0) {
				arr[s2.charAt(j) - 'a']--;
				cnt += 2;
			}
		}
		int res = len - cnt;
		System.out.println(res);
	}

}
