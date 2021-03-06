import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Alg_10814 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Node> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			list.add(new Node(age, name));
		}
		Collections.sort(list);
		for(int i=0; i<n; i++) {
			System.out.println(list.get(i).age + " " + list.get(i).name);
		}
		
	}

}
class Node implements Comparable<Node>{
	int age;
	String name;
	Node(int age, String name){
		this.age = age;
		this.name = name;
	}
	public int compareTo(Node c) {
		
		if(this.age > c.age)
			return 1;
		else if(this.age < c.age)
			return -1;
		else
			return 0;
			
//		return this.age > c.age ? 1 : -1;
	}
}