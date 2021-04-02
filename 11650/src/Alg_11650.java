import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Alg_11650 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i][0] = x;
			arr[i][1] = y;
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0] == o2[0]) {	// x좌표값이 같다면 y좌표 기준으로 정렬
					return Integer.compare(o1[1], o2[1]);
				} else {		// x좌표 값이 다르다면 x좌표 기준으로 정렬
					return Integer.compare(o1[0], o2[0]);
				}
			}});
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
		
	}
}