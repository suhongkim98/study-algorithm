#include <iostream>
using namespace std;
 //https://www.acmicpc.net/problem/2753
 
int solve(int n) {
    if((n % 4 == 0 && n % 100 != 0) || (n % 400 == 0)) {
        return 1;
    }
    return 0;
}
int main(void)
{
    int result, a;
    cin >> a;
    
    result = solve(a);
    cout << result;
    return 0;
}
