package leetcode_13;
import java.util.Scanner;

public class leetcode_13 {

	static public int getValue(char ch) {
		switch (ch) {
			case 'I':	return 1;
			case 'V':	return 5;
			case 'X':	return 10;
			case 'L':	return 50;
			case 'C':	return 100;
			case 'D':	return 500;
			case 'M':	return 1000;
		}
		return 0;
	}
	static public int romanToInt(String s) {
		String[] str = s.split("");
		int ans = 0;
		
		int pre = getValue(s.charAt(0));
		ans += pre;
		for(int i=1; i<str.length; i++) {
			
			int cur = getValue(s.charAt(i));
			
			if(pre < cur) {
				ans = ans - pre - pre + cur;
			} else {
				ans += cur;
			}
			pre = cur;
			
		}
	
		
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		System.out.println(romanToInt(s));
		
	}

}
class Number {
	String s;
	int n;
	Number(String s, int n){
		this.s = s;
		this.n = n;
	}
}
