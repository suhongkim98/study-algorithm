#include <iostream>
using namespace std;
 //https://www.acmicpc.net/problem/2884
 
void solve(int a, int b) {
    b = (b - 45 + 60) % 60;
    if(b >= 15) {
        a = (a - 1 + 24) % 24;
    }
    cout << a << ' ' << b;
}
int main(void)
{
    int a, b;
    cin >> a >> b;
    
    solve(a,b);
    return 0;
}
