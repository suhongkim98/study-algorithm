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
	static int[] dp = new int[1000001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		bw.write(solve(n)+ "");
		bw.flush();
		bw.close();
        br.close();
	}
	static int solve(int n) {
		if(dp[n] != 0) return dp[n];
	    if (n == 1) return 1;
	    if (n == 2) return 2;
	    return dp[n] = (solve(n-1) + solve(n-2))  % 15746;
	}
}
