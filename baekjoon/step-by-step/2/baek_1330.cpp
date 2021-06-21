#include <iostream>
using namespace std;
 //https://www.acmicpc.net/problem/1330
int main(void)
{
    int a, b;
    cin >> a >> b;
    
    if(a > b) {
        cout << ">";
    } else if( a < b) {
        cout << "<";
    } else {
        cout << "==";
    }
    return 0;
}
