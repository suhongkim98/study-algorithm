#include <iostream>
using namespace std;
 //https://www.acmicpc.net/problem/2588
int main(void)
{
    int a, b, result;
    cin >> a >> b;
    result = a * b;
    
    while(b > 0) {
        cout << a * (b % 10) << endl;
        b = b / 10;
    }
    cout << result;
    return 0;
}
