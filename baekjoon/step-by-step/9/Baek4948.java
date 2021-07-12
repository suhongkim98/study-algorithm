import java.util.*;
//https://www.acmicpc.net/problem/4948
public class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int input;
        int num = 123456 * 2;
 
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
        do{
            input = sc.nextInt();
            if(input == 0) break;
            int count = 0;
            for(int i = input + 1 ; i <= 2 * input ; i++) {
                if(arr[i]) count++;
            }
            System.out.println(count);
        }while(input != 0);
        sc.close();
    }
}
