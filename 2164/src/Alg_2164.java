import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Alg_2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] q = new int[2 * n];
		for(int i=1; i<=n; i++) {
			q[i] = i;
		}
		int start = 1;
		int end = n;
		while(true) {
			if(start == end) {
				System.out.println(q[start]);
				return;
			}
			if(start % 2 == 1) {
				start++;
			}
			else {
				q[end + 1] = q[start]; 
				start++;
				end++;
			}
		}
	}

}
