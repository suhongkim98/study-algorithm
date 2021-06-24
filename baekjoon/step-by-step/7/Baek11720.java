import java.util.*;
//https://www.acmicpc.net/problem/11720
public class Main{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
        char[] arr = scanner.next().toCharArray();
        int total = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            total += Character.getNumericValue(arr[i]);
        }
        System.out.println(total);
        scanner.close();
    }
}
