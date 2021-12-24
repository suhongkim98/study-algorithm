import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		recur(map, 0, N - 1, 0, N - 1);
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0; j < N ; j++) {
				if(map[i][j] == 1) result.append("*");
				else result.append(" ");
			}
			result.append('\n');
		}
		System.out.println(result);
        br.close();
	}
	static void recur(int[][] map, int startR, int endR, int startC, int endC) {
		int size = endR - startR + 1;
		if(size % 3 == 0) {
			//분할
			for(int i = 0 ; i < 3 ; i++) {
				for(int j = 0 ; j < 3 ; j++) {
					if(i == 1 && i == j) continue;
					int item = size / 3;
					int newStartR = startR + item * j;
					int newEndR = newStartR + item - 1;
					int newStartC = startC + item * i;
					int newEndC = newStartC + item - 1;
					recur(map, newStartR, newEndR,newStartC,newEndC);
				}
			}
		} else {
			//출력
			map[startR][startC] = 1;
		}
		
	}
}
