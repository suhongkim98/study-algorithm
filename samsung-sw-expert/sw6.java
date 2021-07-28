import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
		    int[] moneys = {50000,10000,5000,1000,500,100,50,10};
		    int[] count = new int[moneys.length];
		    int n = sc.nextInt();
		    for(int i = 0 ; i < moneys.length ; i++) {
		        if(n / moneys[i] > 0) {
		            count[i] = n / moneys[i];
		            n %= moneys[i];
		        }
		    }
		    System.out.println("#" + test_case);
		    for(int i = 0 ; i < count.length ; i++) {
		        System.out.print(count[i] + " ");
		    }
		    System.out.println();
		}
	}
}
