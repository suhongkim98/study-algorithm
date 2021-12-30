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
		PriorityQueue<Member> q = new PriorityQueue<Member>(new Comparator<Member>() {

			@Override
			public int compare(Member o1, Member o2) {
				if(o1.age < o2.age) return -1;
				else if(o1.age == o2.age) return o1.order - o2.order; 
				return 1;
			}
		});
		
		for(int i = 0 ; i < N ; i++) {
			String[] input = br.readLine().split(" ");
			q.add(new Member(Integer.parseInt(input[0]), input[1], i));
		}
		while(!q.isEmpty()) {
			Member m = q.poll();
			bw.write(m.age + " " + m.name + "\n");
		}
		bw.flush();
		bw.close();
        br.close();
	}
}

class Member {
	int age;
	String name;
	int order;
	public Member(int age, String name, int order) {
		this.age = age;
		this.name = name;
		this.order = order;
	}
}
