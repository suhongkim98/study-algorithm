import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static StringBuilder result =new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		result.append((int)(Math.pow(2, N)-1) + "\n");
		hanoi(N,1,3,2);
		System.out.println(new String(result));
	}
	static void move(int start, int to) {
		result.append(start + " " + to + "\n");
	}
	static void hanoi(int N, int start, int to, int via) {
		if(N == 1) move(start, to);
		else {
			hanoi(N-1, start, via, to);
			move(start, to);
			hanoi(N-1,via, to, start);
		}
	}
}
