import java.util.*;
//https://www.acmicpc.net/problem/9020
//에라토스테네스의 체
public class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int num = 10000;
 
        boolean[] arr = new boolean[num+1];    //true 이면 해당 인덱스 소수.
        arr[0] = arr[1] = false;
        for(int i=2; i<=num; i+=1) {
            arr[i] = true;
        }
 
        //2 부터 숫자를 키워가며 배수들을 제외(false 할당)
        for(int i=2; i*i<=num; i+=1) {
            for(int j=i*i; j<=num; j+=i) {
                arr[j] = false;        //2를 제외한 2의 배수 false
            }
        }
        int size = sc.nextInt();
        int gold = 0;
        for(int i = 0 ; i < size ; i++) {
            int n = sc.nextInt();
            for(int j = 2 ; j <= n / 2 ; j++) {
                if(arr[j]) {
                    int target = n - j;
                    if(arr[target]) {
                        gold = target;
                    }
                }
            }
            System.out.println(n - gold + " " + gold);
        }
        sc.close();
    }
}
