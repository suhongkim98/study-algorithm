import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int CASE = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < CASE ; i++) {
            String[] input = br.readLine().split(" ");
            bw.write(lcm(Integer.parseInt(input[0]), Integer.parseInt(input[1])) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 최대공약수 구하기, 유클리드호제법 재귀방식
    static int gcd(int a, int b) {
        if(a%b ==0) {
            return b;
        }
        return gcd(b, a%b);
    }

    // 최소공배수 : Least Common mulitple
    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}

