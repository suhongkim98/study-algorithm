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
//쿼드트리를 문자열로 바꾸는 문제, 분할정복
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			String input = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		bw.write(solve(map, 0, 0, N));
		bw.flush();
		bw.close();
        br.close();
	}
	static String solve(int[][] map, int posX, int posY, int size) {
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
			return startColor + "";
		}
		//4개로 분할
		return "(" 
		+ solve(map, posX, posY, size / 2) 
		+ solve(map, posX, posY + (size / 2), size / 2) 
		+ solve(map, posX + (size / 2), posY, size / 2) 
		+ solve(map, posX + (size / 2), posY + (size / 2), size / 2) 
		+ ")";
	}
}
