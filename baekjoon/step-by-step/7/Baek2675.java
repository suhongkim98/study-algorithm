import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/2675
public class Main{
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String input = br.readLine();
            if(input == null) break;
            String[] split = input.split(" ");
            if(split.length > 1) {
                for(int i = 0 ; i < split[1].length() ; i++) {
                    for(int j = 0 ; j < Integer.parseInt(split[0]) ; j++) {
                        System.out.print(split[1].charAt(i));
                    }
                }
                    System.out.println();
            }
        }
        br.close();
    }
}
