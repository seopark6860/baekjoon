import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alg_10773 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		
		int[] stack = new int[k];
	
		int index = -1;
		while(k-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			if(n != 0) {
				stack[++index] = n;
			}
			else
				stack[index--] = 0;
		}
		int res = 0;
		for(int i : stack) {
			res += i;
		}
		System.out.println(res);
	}
}