import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/15552
public class Main{
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < size ; i++) {
            String input[] = br.readLine().split(" ");
            bw.write((Integer.parseInt(input[0]) + Integer.parseInt(input[1])) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
