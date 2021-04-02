import java.util.Scanner;

public class Alg_10871 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int X = sc.nextInt();
		
		while(N-- > 0) {
			int z = sc.nextInt();
			if (z < X) {
				System.out.print(z + " ");	}
		}
	}
}
  