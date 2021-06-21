#include <iostream>
using namespace std;
 //https://www.acmicpc.net/problem/14681
 
int solve(int a, int b) {
    int result = 0;
    if(a > 0) {
        if(b > 0) {
            result = 1;
        } else {
            result = 4;
        }
    }
    if(a < 0) {
        if(b > 0) {
            result = 2;
        } else {
            result = 3;
        }
    }
    return result;
}
int main(void)
{
    int result, a, b;
    cin >> a >> b;
    
    result = solve(a,b);
    cout << result;
    return 0;
}
