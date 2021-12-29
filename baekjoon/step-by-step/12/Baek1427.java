import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i = 0 ; i < input.length() ; i++) {
			int n = input.charAt(i) - '0';
			q.add(n);
		}
		while(!q.isEmpty()) {
			bw.write(String.valueOf(q.poll()));
		}
		bw.flush();
		bw.close();
        br.close();
	}
}
