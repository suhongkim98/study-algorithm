import java.util.*;
//https://www.acmicpc.net/problem/2577
public class Main{
    
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int arr[] = new int[10];
        int result = 1;
        for(int i = 0 ; i < 3 ; i++) {
            result *= scanner.nextInt();
        }
        while(result > 0) {
            arr[result % 10]++;
            result /= 10;
        }
        for(int i = 0 ; i < 10 ; i++){
            System.out.println(arr[i]);
        }
        scanner.close();
    }
}
