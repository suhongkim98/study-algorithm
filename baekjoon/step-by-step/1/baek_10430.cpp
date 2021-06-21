#include <iostream>
using namespace std;
 //https://www.acmicpc.net/problem/10430
int main(void)
{
    int a, b, c;
    cin >> a >> b >> c;
    cout << (a+b)%c << endl;
    cout << ((a%c) + (b%c))%c <<endl;
    cout << (a*b)%c << endl;
    cout << ((a%c) * (b%c))%c << endl;
}
