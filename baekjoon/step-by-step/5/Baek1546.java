import java.util.*;
//https://www.acmicpc.net/problem/1546
public class Main{
    
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        double arr[] = new double[scanner.nextInt()];
        double max = 0;
        float sum = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            arr[i] = scanner.nextInt();
            if(max < arr[i]) max = arr[i];
        }
        for(int i = 0 ; i < arr.length ; i++) {
            arr[i] = (arr[i] / max) * 100;
            sum += arr[i];
        }
        System.out.println(sum / arr.length);
        scanner.close();
    }
}
