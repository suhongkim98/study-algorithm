import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);
        bw.write(solve(a,b,c) + "");
        bw.close();
        br.close();
    }

    //분할정복, 2의 4승은 2의2승을 두번 곱한 것과 같다
    //2의 4승을 구하는 것이라면 b가 4->2->1로 줄어듦, 로그n
    static long solve(int a, int b, int c) {
        if(b == 1) return a % c;
        if(b % 2 == 0) {
            long answer = solve(a, b / 2, c) % c;
            return (answer * answer) % c;
        }
        return (solve(a, b - 1, c) * a) % c; // 2의 5승은 2의 4승 곱하기 2
    }
}

