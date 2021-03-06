import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Alg_2751 {
	static int n;
	static int[] arr;
	static int[] tmp;

	public static void merge(int left, int mid, int right) {
		for(int i=left; i<=right; i++) {
			tmp[i] = arr[i];
		}
		
	}
	public static void partition(int left, int right) {
		int mid;
		if(left < right) {
			mid = (left + right) / 2;
			partition(left, mid);
			partition(mid + 1, right);
			merge(left, mid, right);
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		tmp = new int[n];
		partition(0, n-1);
//		mergeSort(0, n-1);
	
	}

}
