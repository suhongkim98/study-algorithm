import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;

class Main {

    /*

n개의 섬 존재

i번째 섬은 i+1 째 섬과 연결, 마지막 섬은 1과 연결
다리는 단방향임, 돌아올 수 없음
I -> I+1번째 섬과 연결된 다리는 여러개 일 수 있음


1번째 섬에서 다돌고 다시 올아오는 경우의 수 구하기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        long sum = 1;
        for(int i = 0 ; i < N ; i++) {
            sum = sum * Integer.parseInt(input[i]);
        }
        bw.write(sum + "");

        br.close();
        bw.close();
    }
}