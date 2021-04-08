import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Alg_1931 {
	static int n;
	static int[][] arr;
	static int cnt = 1;
	
	public static void solve() {
		int end = arr[0][1];
		
		for(int i=1; i<n; i++) {
			if(arr[i][0] >= end) {
				cnt++;
				end = arr[i][1];
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[1] == o2[1]) {		// 끝나는 시간 같으면
					return o1[0] - o2[0];	// 시작시간을 오름차순 정렬
				} else {
					return o1[1] - o2[1];
				}
			}
		});
		solve();
		System.out.println(cnt);
	}

}
