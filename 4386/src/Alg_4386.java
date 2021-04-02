import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Alg_4386 {
	static int n;
	static Star[] stars;
	static int[] parent;
	static ArrayList<Dist> arr;
	static PriorityQueue<Dist> pq = new PriorityQueue<>();;

	public static double kruskal() {
		double ans = 0;

		while (!pq.isEmpty()) {
			Dist d = pq.poll();

			int a = find(d.from);
			int b = find(d.to);

			if (a == b)
				continue;
			union(a, b);
			ans += d.dist;
		}
		return ans;
	}

	public static int find(int x) {
		if (x == parent[x])
			return x;
		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		int a = find(x);
		int b = find(y);

		if (a > b)
			parent[a] = b;
		else
			parent[b] = a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		stars = new Star[n];
		arr = new ArrayList<>();

		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		// 별 위치 저장
		for (int i = 0; i < n; i++) {
			double x = sc.nextDouble();
			double y = sc.nextDouble();

			stars[i] = new Star(x, y, i);
		}
		// 별들간 거리 저장
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				double dis = Math.sqrt(Math.pow(stars[j].x - stars[i].x, 2) + Math.pow(stars[j].y - stars[i].y, 2));
				pq.add(new Dist(i, j, dis));

			}
		}
		System.out.printf("%.2f", kruskal());
	}
}

class Star { // 별들 위치
	double x, y;
	int num;
	Star(double x, double y, int num) {
		this.x = x;
		this.y = y;
		this.num = num;
	}
}

class Dist implements Comparable<Dist> { // 별들간거리
	int from, to;
	double dist;

	public Dist(int from, int to, double dist) {
		this.from = from;
		this.to = to;
		this.dist = dist;
	}

	public int compareTo(Dist t) {
		return this.dist > t.dist ? 1 : -1;
	}

}
