import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_10818 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int min, max;
		if(n == 0) {
			min = 0;
			max = 0;
		} else {
			min = arr[0];
			max = arr[0];
		}
		for(int i=0; i<n; i++) {
			if(arr[i] < min)
				min = arr[i];
			if(arr[i] > max)
				max = arr[i];
		}
		System.out.println(min + " " + max);
	}

}
