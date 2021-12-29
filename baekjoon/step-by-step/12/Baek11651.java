import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Point> q = new PriorityQueue<Point>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if(o1.y < o2.y) return -1;
				else if(o1.y == o2.y) {
					if(o1.x < o2.x) return -1;
					else return 1;
				}
				return 1;
			}
			
		});
		for(int i = 0 ; i < N ; i++) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			q.add(new Point(x,y));
			
		}
		while(!q.isEmpty()) {
			Point point = q.poll();
			bw.write(point.x + " " + point.y + "\n");
		}
		bw.flush();
		bw.close();
        br.close();
	}
}
