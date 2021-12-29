import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int sum = 0;
		int val = arr[0];
		int count = 0;
		int modeCount = Integer.MIN_VALUE; //최빈값 카운트
		int mode = arr[0];
		//합 및 최빈값 카운트 구하기
		Map<Integer, Integer> map = new HashMap<>();
		Queue<Pair> q = new LinkedList<>();
		for(int i = 0 ; i < N ; i++) {
			sum += arr[i];
			//
			if(val == arr[i]) {
				count++;
			} else {
				if(modeCount < count) {
					modeCount = count;
				}
				q.add(new Pair(arr[i-1],count));
				val = arr[i];
				count = 1; // 초기화
			}
		}
		if(modeCount < count) {
	    	modeCount = count;
	    }
		q.add(new Pair(arr[N-1],count));
		
		//최빈값카운트에 해당하는 인덱스 구하기, 중복되면 2번째 것
		Boolean flag = false;
		while(!q.isEmpty()) {
			Pair pair = q.poll();
			if(pair.y == modeCount) {
				if(!flag) {
					flag = true;
					mode = pair.x;
				} else {
					mode = pair.x;
					break;
				}
			}
		}
		bw.write((Math.round(sum / (double)N)) + "\n");
		bw.write(arr[N / 2] + "\n");
		bw.write(mode + "\n");
		bw.write(Math.abs(arr[N - 1] - arr[0]) + "\n");
		bw.flush();
		
		bw.close();
        br.close();
	}
}
class Pair {
	int x;
	int y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
