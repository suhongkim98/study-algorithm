import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;

class Main {

    /*
contains 메서드 활용해 문자열 포함여부 확인
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        int count = 0;
        for(int i = 0 ; i < Integer.parseInt(input[0]) ; i++) {
            if(br.readLine().contains(input[1])) count++;
        }
        bw.write(count + "");

        br.close();
        bw.close();
    }
}