import java.util.Scanner;

public class Alg_2839 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		if(n%5 == 0) {
			System.out.println(n/5);
			return;
		}else {
			int cnt = n/5;
			for(int i=cnt; i>0; i--) {
				int num = n-(5*i);
				if(num%3 == 0) {
					System.out.println(i+(num/3));
					return;
				}
			}
		}
		if(n%3 == 0) {
			System.out.println(n/3);
			
		}else 
			System.out.println(-1);
		
	}

}
