import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;

class Main {

    /*
에라토스테네스의-체 사용
i가 소수인 경우 a[i]의 합 구하기, i는 1부터 시작
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Solution s = new Solution(100001);
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int sum = 0;
        for(int i = 1 ; i < N + 1 ; i++) {
            int n = Integer.parseInt(input[i - 1]);
            if(s.isPrime(i)) sum += n;
        }
        bw.write(sum + "");
        br.close();
        bw.close();
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