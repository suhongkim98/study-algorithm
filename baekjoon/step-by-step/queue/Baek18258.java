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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		List<Integer> q = new LinkedList<>();
		for(int i = 0 ; i < N ; i++) {
			String[] input = br.readLine().split(" ");
			if(input.length == 1) {
				if(input[0].equals("pop")) {
					if(q.isEmpty()) bw.write("-1\n");
					else {
						int v = q.remove(0);
						bw.write(v + "\n");
					}
				}
				if(input[0].equals("size")) {
					bw.write(q.size() + "\n");
				}
				if(input[0].equals("empty")) {
					bw.write(q.isEmpty() ? "1\n" : "0\n");
				}
				if(input[0].equals("front")) {
					if(q.isEmpty()) bw.write("-1\n");
					else {
						int v = q.get(0);
						bw.write(v + "\n");
					}
				}
				if(input[0].equals("back")) {
					if(q.isEmpty()) bw.write("-1\n");
					else {
						int v = q.get(q.size() - 1);
						bw.write(v + "\n");
					}
				}
			} else if(input[0].equals("push")) {
				int n = Integer.parseInt(input[1]);
				q.add(n);
			}
		}
		bw.flush();
		bw.close();
        br.close();
	}
}
