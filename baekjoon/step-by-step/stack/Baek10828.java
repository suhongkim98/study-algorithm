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
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main {
	static Long[] dp = new Long[101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		for(int i = 0 ; i < N ; i++) {
			String[] input = br.readLine().split(" ");
			if(input.length == 1) {
				if(input[0].equals("top")) {
					if(s.isEmpty()) bw.write("-1\n");
					else bw.write(s.peek()+"\n");
				}
				if(input[0].equals("size")) {
					bw.write(s.size()+"\n");
				}
				if(input[0].equals("empty")) {
					bw.write(s.isEmpty() ? "1\n" : "0\n");
				}
				if(input[0].equals("pop")) {
					if(s.isEmpty()) bw.write("-1\n");
					else bw.write(s.pop()+"\n");
				}
			} else if(input[0].equals("push")) {
				int n = Integer.parseInt(input[1]);
				s.push(n);
			}
		}
		bw.flush();
		bw.close();
        br.close();
	}
}
