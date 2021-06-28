import java.util.*;
//https://www.acmicpc.net/problem/5622
public class Main{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int delay = 0;
        for(int i = 0 ; i < input.length() ; i++) {
            int n = input.charAt(i) - 'A';
            if(n <= 2) {
                delay += 3;
            } else if(n <= 5) {
                delay += 4;
            } else if(n <= 8) {
                delay += 5;
            } else if(n <= 11) {
                delay += 6;
            } else if(n <= 14) {
                delay += 7;
            } else if(n <= 18) {
                delay += 8;
            } else if(n <= 21) {
                delay += 9;
            } else {
                delay += 10;
            }
        }
        System.out.println(delay);
        scanner.close();
    }
}
