import java.io.*;
import java.util.*;

//정수론, 약수가 모두 주어졌을 때 n을 구하는 방법은 가장 작은 약수(1제외)와 큰 약수를 곱한다
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < N ; i++) {
            int n = Integer.parseInt(input[i]);
            if(max < n) max = n;
            if(min > n) min = n;
        }
        bw.write((max * min) + "");

        bw.flush();
        br.close();
        bw.close();
    }
}

