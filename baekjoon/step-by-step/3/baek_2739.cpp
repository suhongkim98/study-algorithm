#include <iostream>
using namespace std;
 //https://www.acmicpc.net/problem/2739
 
void solve(int a) {
    for(int i = 1 ; i <= 9 ; i++) {
        cout << a << " * " << i << " = " << a * i << endl;
    }
}
int main(void)
{
    int a;
    cin >> a;
    
    solve(a);
    return 0;
}
