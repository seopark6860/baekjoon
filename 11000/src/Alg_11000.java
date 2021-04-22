import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Alg_11000 {
	static int n;
	static Lecture[] lectures;
	static PriorityQueue<Lecture> pq = new PriorityQueue<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		lectures = new Lecture[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			lectures[i] = new Lecture(s, t);
		}
		Arrays.sort(lectures, new Comparator<Lecture>() {
			@Override
			public int compare(Lecture o1, Lecture o2) {
				// TODO Auto-generated method stub
				if(o1.start == o2.start)		// 시작시간 빠른순, 종료시간 빠른 순으로 정렬
					return o1.end - o2.end;
				else
					return o1.start - o2.start;
			}
		});
		pq.add(lectures[0]);	// 첫번째 강의 넣고		
		for(int i=1; i<n; i++) {
			if(pq.peek().end <= lectures[i].start) {
				pq.poll();
				pq.add(new Lecture(lectures[i].start, lectures[i].end));
			}
			else {
				pq.add(new Lecture(lectures[i].start, lectures[i].end));
			}
		}
		System.out.println(pq.size());
	}

}
class Lecture implements Comparable<Lecture>{
	int start;
	int end;
	Lecture(int start, int end){
		this.start = start;
		this.end = end;
	}
	public int compareTo(Lecture c) {	// 종료시간이 가장 빠른 순으로 정렬
		return this.end - c.end;
	}
}