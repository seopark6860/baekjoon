import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_2460 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int sum = 0;
		int in = 0;
		int out = 0;
		int max = 0;
		for(int i=0; i<10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			out = Integer.parseInt(st.nextToken());
			in = Integer.parseInt(st.nextToken());
			sum = sum + in - out;
			if(sum > max)
				max = sum;
		}
		System.out.println(max);
	}

}
