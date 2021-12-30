import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<String>();
		PriorityQueue<String> q = new PriorityQueue<String>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() < o2.length()) return -1;
				else if(o1.length() == o2.length()) return o1.compareTo(o2);
				return 1;
			}
		});
		for(int i = 0 ; i < N ; i++) {
			String input = br.readLine();
			set.add(input);
		}
		set.stream().forEach(elem -> {
			q.add(elem);
		});
		while(!q.isEmpty()) {
			String target = q.poll();
			bw.write(target+"\n");
		}
		bw.close();
        br.close();
	}
}
