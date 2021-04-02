import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Alg_3460 {
	
	public static void solve(int num, ArrayList<Integer> arr) {
		if(num == 0)
			return;
		arr.add(num % 2);
		solve(num / 2, arr);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- >0) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr = new ArrayList<>();
			solve(n, arr);
			for(int i=0; i<arr.size(); i++) {
				if(arr.get(i) == 1)
					System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
