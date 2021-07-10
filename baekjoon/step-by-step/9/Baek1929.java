import java.util.*;
//https://www.acmicpc.net/problem/1929
//에라토스테네스의 체 알고리즘
public class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int num = sc.nextInt();
 
        boolean[] arr = new boolean[num+1]; 
        arr[0] = arr[1] = false;
        for(int i=2; i<=num; i+=1) {
            arr[i] = true;
        }
 
        for(int i=2; i*i<=num; i+=1) {
            for(int j=i*i; j<=num; j+=i) {
                arr[j] = false;
            }
        }
        for(int i=start; i<=num; i+=1) {
            if(true == arr[i]) {
                System.out.println(i);
            }
        }
        System.out.println();
    }
}
