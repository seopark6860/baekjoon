import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Alg_3273 {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(br.readLine());
		int cnt = 0;
		int s = 0;
		int e = n - 1;
		int sum = 0;
		
		Arrays.sort(arr);
		while(s < e) {
			sum = arr[s] + arr[e];
			if (sum == x) 
				cnt++;
			if (sum <= x)
				s++;
			else
				e--;
		}
		System.out.println(cnt);
	}

}
