import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/10951
public class Main{
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            String input = br.readLine();
            if(input == null) break; // 버퍼가 없으면 끝을 만난 것
            String nums[] = input.split(" ");
            System.out.println(Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
