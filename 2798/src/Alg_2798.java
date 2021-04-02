import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Alg_2798 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int sum = 0;
		int max = 0;
		
		int[] arr = new int[n];
		ArrayList<Integer> list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		for(int i=0; i<n; i++) {
			sum = arr[i];
			for(int j=i+1; j<n; j++) {
				sum += arr[j];
				for(int k=j+1; k<n; k++) {
					sum += arr[k];
					if(max < sum && sum <= m)
						max = sum;
					sum -= arr[k];
				}
			sum -= arr[j];
			}
		}
//		Collections.sort(list);
//		int len = list.size();
//		System.out.println(list.get(len - 1));
		System.out.println((max));
	}

}
