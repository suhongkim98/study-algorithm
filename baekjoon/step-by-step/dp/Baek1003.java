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
	static Counter[] dp = new Counter[41];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < N ; i++) {
			int n = Integer.parseInt(br.readLine());
			fibo(n);
			bw.write(fibo(n).zero + " " + fibo(n).one + "\n");
		}
		bw.close();
        br.close();
	}
	static Counter fibo(int n) {
		if(dp[n] != null) return dp[n];
	    if (n == 0) {
	    	dp[n] = new Counter(1,0);
	    } else if (n == 1) {
	    	dp[n] = new Counter(0,1);
	    } else {
	    	Counter counter = new Counter(fibo(n - 1).zero + fibo(n - 2).zero, fibo(n - 1).one + fibo(n - 2).one);
	        dp[n] = counter;
	    }
	    return dp[n];
	}
}
class Counter {
	int zero;
	int one;
	public Counter(int zero, int one) {
		this.zero = zero;
		this.one = one;
	}
}
