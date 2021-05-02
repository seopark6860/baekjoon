import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Alg_1339 {
	static int n, ans = 0;
	static String[] str;
	static ArrayList<Character> alpha = new ArrayList<>();
	static boolean[] v;
	static int[] val;
	
	public static void solve(int depth) {
		if(depth == alpha.size()) {
			int sum = 0;
			for(int i=0; i<n; i++) {
				int num = 0;
				for(int j=0; j<str[i].length(); j++) {
					num *= 10;
					num += val[alpha.indexOf(str[i].charAt(j))];
				}
				sum += num;
			}
			ans = Math.max(sum, ans);
		}
		else {
			for(int i=0; i<=9; i++) {
				if(v[i]) continue;
				v[i] = true;
				val[depth] = i;
				solve(depth + 1);
				v[i] = false;
				val[depth] = 0;
			}
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		str = new String[n];
		
		for(int i=0; i<n; i++) {
			str[i] = br.readLine();
			for(int j=0; j<str[i].length(); j++) {
				if(!alpha.contains(str[i].charAt(j))) {
					alpha.add(str[i].charAt(j));	// 사용된 알파벳
				}
			}
		}
		v = new boolean[10];
		val = new int[alpha.size()];
		solve(0);
		System.out.println(ans);
	}

}
