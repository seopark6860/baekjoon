import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Alg_1946 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n + 1][2];
			
			for(int i=1; i<=n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());	// 辑幅 己利
				arr[i][1] = Integer.parseInt(st.nextToken());	// 搁立 己利
			}
			Arrays.sort(arr, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o1[0] - o2[0];
				}
				
			});
			int res = 1;
			int cur = arr[1][1];
			for(int i=2; i<=n; i++) {
		/*
				if(arr[1][1] == 1)
					break;
				if(arr[1][1] == n) {
					res = n;
					break;
				}
		*/
				if(arr[i][1] < cur) {
					cur = arr[i][1];
					res++;
				}
			}
			System.out.println(res);
		}
	}

}
 