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
   //음수도 dp에 저장했어야했다면 그거만큼도 dp 사이즈를 늘려줬어야했을 것
	static Long[][][] dp = new Long[21][21][21];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int c = Integer.parseInt(input[2]);
			if(a == -1 && a == b && a == c) break;
			bw.write("w(" + a + ", " + b + ", " + c + ") = " + get(a,b,c) + "\n");
		}
		
		bw.flush();
		bw.close();
        br.close();
	}
	static Long get(int a, int b, int c) {
		if(a <= 0 || b <= 0 || c <= 0) return 1L; // 음수면 무조건 반환이므로 범위는 1~50이다. dp사이즈도 그정도로 맞추자
		if(a > 20 || b > 20 || c > 20) return get(20, 20, 20);	// 20보다 크면 20으로 통일해주므로 범위는 1~20으로 줄어든다. dp 사이즈도 그정도로 맞추자
		    
		if(dp[a][b][c] != null) return dp[a][b][c]; // 이미 계산된 값이면 dp값 반환
		if(a < b  && b < c) {
			dp[a][b][c] = get(a,b,c-1) + get(a,b-1,c-1) - get(a, b-1, c);
			return dp[a][b][c];	
		}
		dp[a][b][c] = get(a-1,b,c) + get(a-1, b-1, c) + get(a-1,b,c-1) - get(a-1,b-1,c-1);
		return dp[a][b][c];	
	}
}
