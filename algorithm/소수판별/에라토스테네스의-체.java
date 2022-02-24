import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution(1000); // 1부터 1000까지 판별해본다.
        System.out.println(s.getPrimeCount());
        System.out.println(s.isPrime(2));
        System.out.println(s.isPrime(3));
        System.out.println(s.isPrime(4));
        System.out.println(s.isPrime(5));
        System.out.println(s.isPrime(7));
        System.out.println(s.isPrime(555));
        System.out.println(s.isPrime(17));
    }
}
class Solution {
    // 2부터 n까지 값을 소수 판별한다.
    int[] prime;
    public Solution(int n){
        prime = new int[n + 1];

        //소수가 아니라면 0, 0과 1은 소수가 아니므로 0
        prime[0] = prime[1] = 0;

        for(int i = 2; i <=n; i++) prime[i] = i; //2부터 소수를 구하고자 하는 구간의 모든 수 나열

        for(int i = 2; i < n;i++){
            if(prime[i] == 0) continue; //소수가 아니라면 continue
            for(int j = 2*i; j <=n; j+=i) prime[j] = 0; //소수의 배수는 소수를 약수로 가지므로 제외
        }
    }
    public boolean isPrime(int n) {
        // n의 수가 소수인지 판별
        return prime[n] != 0; // 0이 아닌 수이면 소수이다.
    }
    public int getPrimeCount() {
        // 1부터 n까지의 수 중 소수 개수 반환
        int answer = 0;

        //소수 개수 구하기
        for(int i = 0; i <prime.length; i++)
            if (isPrime(i)) answer++;

        return answer;
    }
}
