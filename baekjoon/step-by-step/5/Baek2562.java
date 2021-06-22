import java.util.*;
//https://www.acmicpc.net/problem/2562
public class Main{
    
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int arr[] = new int[9];
        int max = 0;
        for(int i = 0 ; i < 9 ; i++) {
            arr[i] = scanner.nextInt();
            if(arr[max] < arr[i]) max = i;
        }
        System.out.println(arr[max] + "\n" +(max + 1));
        scanner.close();
    }
}
