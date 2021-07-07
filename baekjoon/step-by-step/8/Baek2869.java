import java.util.*;
import java.io.*;
//https://www.acmicpc.net/problem/2869
public class Main{
    public static void main(String []args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int v = Integer.parseInt(input[2]);
        double move = a - b;
        double diff = v - a;
        int count = diff == 0 ? 1 : diff < move ? 2 : (int)(Math.ceil(diff / move) + 1);
        System.out.println(count);
        bf.close();
    }
}
