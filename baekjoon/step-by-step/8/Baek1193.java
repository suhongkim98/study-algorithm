import java.util.*;
//https://www.acmicpc.net/problem/1193
public class Main{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 1, count = 1;
        int last = 0;
        while(count < n) {
            if(i % 2 == 0) {
                count += last = i * 2;
            } else {
                count += last = 1;
            }
            i++;
        }
        if(count == n) {
            System.out.println(1 + "/" + i);
        } else {
            if(count - i >= n) {
                count -= last;
                i--;
            }
            if(i % 2 == 0) {
                for(int j = 0 ; j < i ; j++) {
                    if(count + j == n) {
                        System.out.println((j + 1) + "/" + (i - j));
                        break;
                    }
                }
            } else {
                for(int j = 0 ; j < i ; j++) {
                    if(count - j == n) {
                        System.out.println((j + 1) + "/" + (i - j));
                        break;
                    }
                }
            }
            
        }
        scanner.close();
    }
}
