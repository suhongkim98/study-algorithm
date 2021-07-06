import java.util.*;
//https://www.acmicpc.net/problem/10757
public class Main{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.next();
        String input2 = scanner.next();
        Stack<Integer> result = new Stack<>();
        int tmp = 0;
        while(input1.length() > 0 || input2.length() > 0) {
            int n1 = 0;
            int n2 = 0;
            if(input1.length() > 0) {
                n1 = Character.getNumericValue(input1.charAt(input1.length() - 1));
                input1 = input1.substring(0, input1.length() - 1);
            }
            if(input2.length() > 0) {
                n2 = Character.getNumericValue(input2.charAt(input2.length() - 1));
                input2 = input2.substring(0, input2.length() - 1);
            }
            result.push((n1 + n2 + tmp) % 10);
            tmp = (n1 + n2 + tmp) / 10;
        }
        if(tmp != 0) {
            result.push(tmp);
        }
        while(!result.empty()) {
            System.out.print(result.pop());
        }
        scanner.close();
    }
}
