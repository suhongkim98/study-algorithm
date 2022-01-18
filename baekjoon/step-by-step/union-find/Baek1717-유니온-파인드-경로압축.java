import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
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
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int[] parent = new int[n + 1];
		//make set
		for(int i = 0 ; i < n + 1 ; i++) {
			UnionFind.makeSet(parent, i);
		}
		
		for(int i = 0 ; i < m ; i++) {
			input = br.readLine().split(" ");
			int type = Integer.parseInt(input[0]);
			int a = Integer.parseInt(input[1]);
			int b = Integer.parseInt(input[2]);
			
			if(type == 0) {
				//union
				UnionFind.unionSet(parent, a, b);
			} else {
				if(UnionFind.findSet(parent, a) == UnionFind.findSet(parent, b)) {
					bw.write("YES\n");
				} else {
					bw.write("NO\n");
				}
 			}
		}
		
		bw.flush();
		bw.close();
        br.close();
	}
	
}
class UnionFind {
    //유일한 멤버 v를 포함하는 새로운 집합을 생성한다.
    //자기 자신을 가리킨다는 의미는 해당 집합의 대표원소라는 의미다.
    static void makeSet(int[] parent, int v) {
        parent[v] = v;
    }
    //v를 포함하는 집합을 찾는 연산
    static int findSet(int[] parent, int v) {
        //parent[v] == v라면(자기 자신을 가리킨다면) 해당 원소는 해당 집합의 대표원소이므로 리턴
        //아니라면 해당 원소는 대표원소가 아니므로 재귀로 타고타고 들어간다.
        if(v == parent[v]) return v;
        return parent[v] = findSet(parent, parent[v]); // 경로압축
    }
    //u와 v 원소를 포함하는 두 집합을 통합하는 연산
    static void unionSet(int[] parent, int u, int v) {
        parent[findSet(parent, u)] = findSet(parent, v);
    }
}
