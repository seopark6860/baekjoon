import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Alg_2108 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		// ������
		double sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		System.out.println(Math.round(sum/n));
		
		// �߾Ӱ�
		Arrays.sort(arr);
		System.out.println(arr[arr.length / 2]);
		
		// �ֺ�
		int[] count = new int[8001];
		int cnt = 0;
		int max = 0;
		int res = 0;
		for(int i : arr) {
			count[i + 4000]++;
		}
		for(int i=0; i<8001; i++) {
			max = Math.max(max, count[i]);
		}
//		System.out.println("max :: " + max);
		
		
		for(int i=0; i<8001; i++) {
			if(count[i] == max && cnt == 0) {	// �ֺ� �� ���� ���� ��
				res = i;
				cnt++;
			}
			else if(count[i] == max && cnt == 1) {
				res = i;
				break;
			}
		}
		System.out.println(res - 4000);

		//����
		System.out.println(arr[arr.length-1] - arr[0]);
	}

}
