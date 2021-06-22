import java.util.*;
//https://www.acmicpc.net/problem/10818
public class Main{
    
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int arr[] = new int[size];
        int max = 0, min = 0;
        for(int i = 0 ; i < size ; i++) {
            arr[i] = scanner.nextInt();
            if(arr[max] < arr[i]) max = i;
            if(arr[min] > arr[i]) min = i;
        }
        System.out.println(arr[min] + " " + arr[max]);
        scanner.close();
    }
}
