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
			int n = Integer.parseInt(br.readLine());
			if(n == 0) {
				if(!s.isEmpty()) s.pop();
			}
			else {
				s.push(n);
			}
		}
		int sum = 0;
		while(!s.isEmpty()) {
			sum += s.pop();
		}
		bw.write(sum+"");
		bw.flush();
		bw.close();
        br.close();
	}
}
