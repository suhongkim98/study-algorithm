import java.util.*;
import java.io.*;
//https://www.acmicpc.net/problem/1157
public class Main{
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toUpperCase();
        int[] count = new int[26];
        for(int i = 0 ; i < input.length() ; i++) {
            count[input.charAt(i) - 'A']++;
        }
        int max = -1, maxCount = -1, freq = 0;
        for(int i = 0 ; i < 26 ; i++) {
            if(maxCount < count[i]) {
                max = i;
                maxCount = count[i];
            }
        }
        for(int i = 0 ; i < 26 ; i++) {
            if(maxCount == count[i]) {
                freq++;
            }
        }
        if(freq == 1) {
            System.out.println((char)(max + 'A'));
        } else {
            System.out.println("?");
        }
        br.close();
    }
}
