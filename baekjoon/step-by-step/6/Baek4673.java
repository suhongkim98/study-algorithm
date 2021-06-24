import java.util.*;
//https://www.acmicpc.net/problem/4673
public class Main{
    public static void main(String []args){
        int[] arr = new int[10001];
        for(int constructor = 0 ; constructor <= 10000 ; constructor++){
            int n = constructor;
            int calc = n;
            while(n > 0) {
                calc += n % 10;
                n /= 10;
            }
            if(calc <= 10000) {
                arr[calc]++;
            }
        }
        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] == 0) {
                //print self number
                System.out.println(i);
            }
        }
    }
}
