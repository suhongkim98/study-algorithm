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
	static Long[] dp = new Long[101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < N ; i++) {
			int n = Integer.parseInt(br.readLine());
			bw.write(solve(n)+ "\n");
		}
		bw.flush();
		bw.close();
        br.close();
	}
	static Long solve(int n) {
		if(dp[n] != null) return dp[n];
		if(n <= 3) {
			dp[n] = 1L;
			return 1L;
		}
	    return dp[n] = solve(n-2) + solve(n-3);
	}
}
