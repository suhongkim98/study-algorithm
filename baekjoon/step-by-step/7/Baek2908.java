import java.util.*;
//https://www.acmicpc.net/problem/2908
public class Main{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        StringBuffer sb = new StringBuffer(scanner.nextLine());
        String[] numbers = sb.reverse().toString().split(" ");
        
        if(Integer.parseInt(numbers[0]) > Integer.parseInt(numbers[1])) System.out.println(numbers[0]);
        else System.out.println(numbers[1]);
        
        scanner.close();
    }
}
