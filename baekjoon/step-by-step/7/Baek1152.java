import java.util.*;
//https://www.acmicpc.net/problem/1152
public class Main{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split(" ");
        if(input[0].length() == 0) System.out.println(0);
        else System.out.println(input.length);
        scanner.close();
    }
}
