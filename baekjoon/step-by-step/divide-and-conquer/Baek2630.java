import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Main {
	static int countW = 0;
	static int countB = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			String[] input = br.readLine().split(" ");
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		solve(map, 0, 0, N);
		bw.write(countW + "\n");
		bw.write(countB + "\n");
		bw.flush();
		bw.close();
        br.close();
	}
	static void solve(int[][] map, int posX, int posY, int size) {
		if(size > 0) {
			int startColor = map[posX][posY];
			boolean flag = false;
			//분할 조건
			for(int i = posX ; i < size + posX ; i++) {
				for(int j = posY ; j < size + posY ; j++) {
					if(startColor != map[i][j]) {
						//다르면 분할해야함
						flag = true;
					}
				}
				if(flag) break;
			}
			if(!flag) {
				if(startColor == 0) countW++;
				else countB++;
				return;
			}
			//4개로 분할
			solve(map, posX, posY, size / 2);
			solve(map, posX, posY + (size / 2), size / 2);
			solve(map, posX + (size / 2), posY, size / 2);
			solve(map, posX + (size / 2), posY + (size / 2), size / 2);
			
		}
	}
}
