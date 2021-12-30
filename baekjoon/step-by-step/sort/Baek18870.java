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

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] orgArr = new int[N];
		String[] input = br.readLine().split(" ");
		for(int i = 0 ; i < N ; i++) {
			orgArr[i] = Integer.parseInt(input[i]);
		}
		int[] orderArr = Arrays.copyOf(orgArr, N);
		//정렬
		Arrays.sort(orderArr);
		//순위 지정 후 map에 삽입
		int order = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0 ; i < N ; i++) {
			if(!map.containsKey(orderArr[i])) {
				map.put(orderArr[i], order++);
			}
		}
		//map에서 꺼내서 순위로 사용
		for(int i = 0 ; i < N ; i++) {
			bw.write(map.get(orgArr[i]) + " ");
		}
		bw.flush();
		bw.close();
        br.close();
	}
}
