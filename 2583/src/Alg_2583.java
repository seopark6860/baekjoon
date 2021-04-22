import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Alg_2583 {
	static int[] dx= {0, 1, 0, -1};
	static int[] dy= {1, 0, -1, 0};
	static int row, col, k, size;
	static int[][] arr;
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void printMap() {
		for(int i=0; i<col; i++) {
			for(int j=0; j<row; j++) {
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
		}
	}
	public static void dfs(int x, int y) {
		arr[x][y] = -1;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || nx >= col || ny < 0 || ny >= row)
				continue;
			if(arr[nx][ny] == 0) {
				size++;
				dfs(nx, ny);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		col = Integer.parseInt(st.nextToken());		// m
		row = Integer.parseInt(st.nextToken());		// n
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[col][row];
		while(k-- > 0) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());	// row
			int c1 = Integer.parseInt(st.nextToken());	// col
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<col; i++) {
				for(int j=0; j<row; j++) {
					if(r1 <= j && j < r2 && c1 <= i && i < c2) {
						arr[i][j] = 1;
					}
				}
			}
		}
//		printMap();
		int cnt = 0;
		for(int i=0; i<col; i++) {
			for(int j=0; j<row; j++) {
				if(arr[i][j] == 0) {
					cnt++;
					size = 1;
					dfs(i, j);
					list.add(size);
				}
			}
		}
//		printMap();
		Collections.sort(list);
		System.out.println(cnt);
		for(int i : list) {
			System.out.print(i + " ");
		}
	}

}
